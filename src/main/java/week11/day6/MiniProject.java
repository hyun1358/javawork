package week11.day6;

import java.lang.annotation.*;
import java.lang.reflect.Field;

// =========================================================================
// [1] 커스텀 어노테이션 정의 (Retention과 Target을 지정해 보세요.)
// =========================================================================
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Table {
    String name();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}

// =========================================================================
// [2] Enum 심화 (Category 정의: 한글 이름을 생성자 매핑해 보세요.)
// =========================================================================
enum Category {
    ELECTRONICS("가전제품"),
    FOOD("식품"),
    FASHION("의류");

    private final String koreanName;

    Category(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }
}

// =========================================================================
// [3] ProductEntity 클래스 (어노테이션 부여 및 빌더 패턴을 적용해 보세요.)
// =========================================================================
@Table(name = "products")
class ProductEntity {
    @Column(name = "prod_id")
    private Long id;

    @Column(name = "prod_name")
    private String name;

    @Column(name = "prod_price")
    private int price;

    @Column(name = "prod_category")
    private Category category;

    // 빌더 패턴을 사용할 수 있도록 private 생성자를 설계하세요.
    private ProductEntity(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
        this.category = builder.category;
    }

    // 외부에서 빌더를 시작할 수 있게 해주는 static 메서드
    public static Builder builder() {
        return new Builder();
    }

    // ProductEntity 전용 내부 정적 Builder 클래스 구현
    public static class Builder {
        private Long id;
        private String name;
        private int price;
        private Category category;

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

        public Builder category(Category category) {
            this.category = category;
            return this;
        }

        // 최종 객체를 생성하여 반환하는 build() 메서드
        public ProductEntity build() {
            return new ProductEntity(this);
        }
    }
}

// =========================================================================
// [4] 전략 패턴 (QueryExecutionStrategy 인터페이스 및 구체적 전략 구현)
// =========================================================================
interface QueryExecutionStrategy {
    void execute(String sql);
}

class PrintStrategy implements QueryExecutionStrategy {
    @Override
    public void execute(String sql) {
        System.out.println("[SQL 실행 (콘솔출력)] : " + sql);
    }
}

class UpperCaseStrategy implements QueryExecutionStrategy {
    @Override
    public void execute(String sql) {
        System.out.println("[SQL 실행 (대문자)] : " + sql.toUpperCase());
    }
}

// =========================================================================
// [5] SmartOrmEngine 클래스 (싱글톤 패턴 및 리플렉션 쿼리 빌더 완성)
// =========================================================================
class SmartOrmEngine {
    // 5-1. Eager/Lazy 싱글톤 패턴으로 단 하나의 인스턴스를 유지하세요.
    private static final SmartOrmEngine instance = new SmartOrmEngine();

    private QueryExecutionStrategy strategy;

    private SmartOrmEngine() {
        // 기본 전략은 PrintStrategy로 지정합니다.
        this.strategy = new PrintStrategy();
    }

    public static SmartOrmEngine getInstance() {
        return instance;
    }

    public void setStrategy(QueryExecutionStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 리플렉션을 이용해 객체의 어노테이션과 값을 파싱하여 INSERT 쿼리를 생성합니다.
     */
    public String generateInsertQuery(Object entity) throws Exception {
        Class<?> clazz = entity.getClass();

        // 1) @Table 어노테이션이 붙어 있는지 확인하고 테이블명을 가져오세요.
        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new IllegalArgumentException("엔티티에 @Table 어노테이션이 존재하지 않습니다.");
        }
        Table table = clazz.getAnnotation(Table.class);
        String tableName = table.name();

        StringBuilder cols = new StringBuilder();
        StringBuilder vals = new StringBuilder();

        // 2)getDeclaredFields()를 이용해 클래스 내부의 필드들을 가져오세요.
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            // 3) 각 필드에 @Column 어노테이션이 붙어 있는지 검사하고 컬럼명과 필드값을 추출하여 StringBuilder에 조립하세요.
            // (주의: field.setAccessible(true); 호출 필요)
            // TODO: 필드 타입이 String 혹은 Enum인 경우 작은따옴표(')로 값을 감싸도록 처리하세요.
            
        }

        // 마지막 쉼표 제거 처리
        if (cols.length() > 0) {
            cols.setLength(cols.length() - 2);
            vals.setLength(vals.length() - 2);
        }

        return String.format("INSERT INTO %s (%s) VALUES (%s);", tableName, cols, vals);
    }

    /**
     * 쿼리를 빌드하고 주입받은 전략을 활용해 쿼리를 실행(시뮬레이션)합니다.
     */
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
public class MiniProject {
    public static void main(String[] args) {
        // TODO: 1. 빌더 패턴을 이용하여 ProductEntity 객체를 생성해 보세요.
        //          (id: 1L, name: "노트북", price: 1500000, category: Category.ELECTRONICS)
        
        // TODO: 2. SmartOrmEngine 싱글톤 인스턴스를 가져오세요.
        
        // TODO: 3. 기본 전략(PrintStrategy)으로 쿼리를 실행해 보세요.
        
        // TODO: 4. 대문자 전략(UpperCaseStrategy)으로 교체(전략 주입)한 후 다시 실행해 보세요.
        
    }
}
