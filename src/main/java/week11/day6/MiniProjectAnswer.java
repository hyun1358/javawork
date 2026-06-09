package week11.day6;

import java.lang.annotation.*;
import java.lang.reflect.Field;

// =========================================================================
// [1] 커스텀 어노테이션 정의 (이름 충돌 방지를 위해 Answer 접두사 부여)
// =========================================================================
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface AnswerTable {
    String name();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface AnswerColumn {
    String name();
}

// =========================================================================
// [2] Enum 심화 (AnswerCategory 정의: 한글 이름 매핑 및 생성자 구현)
// =========================================================================
enum AnswerCategory {
    ELECTRONICS("가전제품"),
    FOOD("식품"),
    FASHION("의류");

    private final String koreanName;

    AnswerCategory(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }
}

// =========================================================================
// [3] AnswerProductEntity 클래스 (어노테이션 부여 및 빌더 패턴 적용)
// =========================================================================
@AnswerTable(name = "products")
class AnswerProductEntity {
    @AnswerColumn(name = "prod_id")
    private Long id;

    @AnswerColumn(name = "prod_name")
    private String name;

    @AnswerColumn(name = "prod_price")
    private int price;

    @AnswerColumn(name = "prod_category")
    private AnswerCategory category;

    // 빌더 패턴을 적용하기 위한 private 생성자
    private AnswerProductEntity(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
        this.category = builder.category;
    }

    public static Builder builder() {
        return new Builder();
    }

    // Builder 클래스 구현
    public static class Builder {
        private Long id;
        private String name;
        private int price;
        private AnswerCategory category;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(int price) {
            this.price = price;
            return this;
        }

        public Builder category(AnswerCategory category) {
            this.category = category;
            return this;
        }

        public AnswerProductEntity build() {
            return new AnswerProductEntity(this);
        }
    }
}

// =========================================================================
// [4] 전략 패턴 (AnswerQueryExecutionStrategy 인터페이스 및 구현체)
// =========================================================================
interface AnswerQueryExecutionStrategy {
    void execute(String sql);
}

class AnswerPrintStrategy implements AnswerQueryExecutionStrategy {
    @Override
    public void execute(String sql) {
        System.out.println("[SQL 실행 (콘솔출력)] : " + sql);
    }
}

class AnswerUpperCaseStrategy implements AnswerQueryExecutionStrategy {
    @Override
    public void execute(String sql) {
        System.out.println("[SQL 실행 (대문자)] : " + sql.toUpperCase());
    }
}

// =========================================================================
// [5] AnswerSmartOrmEngine 클래스 (싱글톤 및 리플렉션 쿼리 빌더 구현)
// =========================================================================
class AnswerSmartOrmEngine {
    // Eager 싱글톤 패턴으로 단 하나의 인스턴스 제한
    private static final AnswerSmartOrmEngine instance = new AnswerSmartOrmEngine();

    private AnswerQueryExecutionStrategy strategy;

    private AnswerSmartOrmEngine() {
        this.strategy = new AnswerPrintStrategy(); // 기본값 지정
    }

    public static AnswerSmartOrmEngine getInstance() {
        return instance;
    }

    public void setStrategy(AnswerQueryExecutionStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 리플렉션을 통해 객체에서 테이블명 및 컬럼 정보를 읽어 동적 쿼리를 완성시킵니다.
     */
    public String generateInsertQuery(Object entity) throws Exception {
        Class<?> clazz = entity.getClass();

        if (!clazz.isAnnotationPresent(AnswerTable.class)) {
            throw new IllegalArgumentException("엔티티에 @AnswerTable 어노테이션이 존재하지 않습니다.");
        }
        AnswerTable table = clazz.getAnnotation(AnswerTable.class);
        String tableName = table.name();

        StringBuilder cols = new StringBuilder();
        StringBuilder vals = new StringBuilder();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(AnswerColumn.class)) {
                AnswerColumn col = field.getAnnotation(AnswerColumn.class);
                cols.append(col.name()).append(", ");

                field.setAccessible(true);
                Object value = field.get(entity);

                // 값의 타입에 따라 SQL 문자열 포맷팅
                if (value == null) {
                    vals.append("NULL, ");
                } else if (value instanceof String || value instanceof AnswerCategory) {
                    vals.append("'").append(value.toString()).append("', ");
                } else {
                    vals.append(value).append(", ");
                }
            }
        }

        // 마지막 쉼표 제거
        if (cols.length() > 0) {
            cols.setLength(cols.length() - 2);
            vals.setLength(vals.length() - 2);
        }

        return String.format("INSERT INTO %s (%s) VALUES (%s);", tableName, cols, vals);
    }

    public void runQuery(Object entity) {
        try {
            String sql = generateInsertQuery(entity);
            if (strategy != null) {
                strategy.execute(sql);
            }
        } catch (Exception e) {
            System.err.println("ORM 실행 중 에러 발생: " + e.getMessage());
        }
    }
}

// =========================================================================
// [6] 메인 실행 클래스
// =========================================================================
public class MiniProjectAnswer {
    public static void main(String[] args) {
        // 1. 빌더 패턴으로 AnswerProductEntity 생성
        AnswerProductEntity prod = AnswerProductEntity.builder()
                .id(1L)
                .name("노트북")
                .price(1500000)
                .category(AnswerCategory.ELECTRONICS)
                .build();

        // 2. AnswerSmartOrmEngine 싱글톤 인스턴스 획득
        AnswerSmartOrmEngine engine = AnswerSmartOrmEngine.getInstance();

        // 3. 기본 전략(AnswerPrintStrategy)으로 실행 시뮬레이션
        System.out.println("--- 1. 기본 출력 전략 ---");
        engine.runQuery(prod);

        // 4. 대문자 전략(AnswerUpperCaseStrategy)으로 교체하여 실행 시뮬레이션
        System.out.println("\n--- 2. 대문자 출력 전략으로 동적 교체 ---");
        engine.setStrategy(new AnswerUpperCaseStrategy());
        engine.runQuery(prod);
    }
}
