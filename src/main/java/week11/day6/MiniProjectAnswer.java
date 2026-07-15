package week11.day6;

import java.lang.annotation.*;
import java.lang.reflect.Field;

// =========================================================================
// [1] 커스텀 어노테이션 정의 (이름 충돌 방지를 위해 Answer 접두사 부여)
// =========================================================================

// @Retention: 어노테이션이 언제까지 유지될지 지정합니다. RUNTIME은 실행(런타임) 시점에도 리플렉션을 통해 읽을 수 있게 합니다.
@Retention(RetentionPolicy.RUNTIME)
// @Target: 어노테이션을 붙일 수 있는 대상을 지정합니다. TYPE은 클래스, 인터페이스, Enum 등에 붙일 수 있음을 뜻합니다.
@Target(ElementType.TYPE)
@interface AnswerTable {
    // 테이블의 이름을 저장할 엘리먼트입니다. 설정하지 않으면 에러가 나도록 기본값 없이 정의합니다.
    String name();
}

// @Retention: 런타임에 리플렉션 기술로 필드에 붙은 정보를 분석해야 하므로 RUNTIME으로 설정합니다.
@Retention(RetentionPolicy.RUNTIME)
// @Target: FIELD는 클래스의 멤버 변수(필드)에만 이 어노테이션을 붙일 수 있도록 제한합니다.
@Target(ElementType.FIELD)
@interface AnswerColumn {
    // 매핑할 데이터베이스의 컬럼명을 정의하는 엘리먼트입니다.
    String name();
}

// =========================================================================
// [2] Enum 심화 (AnswerCategory 정의: 한글 이름 매핑 및 생성자 구현)
// =========================================================================
enum AnswerCategory {
    // Enum 상수를 정의하면서 생성자에 전달할 한글 설명을 인자로 넘겨줍니다.
    ELECTRONICS("가전제품"),
    FOOD("식품"),
    FASHION("의류");

    // 각 카테고리의 한글명을 저장할 불변(final) 필드입니다.
    private final String koreanName;

    // Enum의 생성자는 암묵적으로 private입니다. 외부에서 직접 호출하여 객체를 생성할 수 없습니다.
    AnswerCategory(String koreanName) {
        this.koreanName = koreanName;
    }

    // 외부에서 한글 설명을 읽을 수 있도록 제공하는 Getter 메서드입니다.
    public String getKoreanName() {
        return koreanName;
    }
}

// =========================================================================
// [3] AnswerProductEntity 클래스 (어노테이션 부여 및 빌더 패턴 적용)
// =========================================================================
// 이 클래스가 데이터베이스의 "products" 테이블과 매핑됨을 나타냅니다.
@AnswerTable(name = "products")
class AnswerProductEntity {
    // prod_id 컬럼과 매핑될 상품의 고유 ID 필드입니다.
    @AnswerColumn(name = "prod_id")
    private Long id;

    // prod_name 컬럼과 매핑될 상품명 필드입니다.
    @AnswerColumn(name = "prod_name")
    private String name;

    // prod_price 컬럼과 매핑될 가격 필드입니다.
    @AnswerColumn(name = "prod_price")
    private int price;

    // prod_category 컬럼과 매핑될 카테고리(Enum) 필드입니다.
    @AnswerColumn(name = "prod_category")
    private AnswerCategory category;

    // 외부에서 직접 new 키워드로 객체를 생성하지 못하게 생성자를 private으로 은닉합니다.
    // 오직 내부의 Builder를 통해서만 필드가 채워진 객체를 생성할 수 있습니다.
    private AnswerProductEntity(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
        this.category = builder.category;
    }

    // 빌더 인스턴스를 편리하게 생성할 수 있도록 제공하는 정적 팩토리 메서드입니다.
    public static Builder builder() {
        return new Builder();
    }

    // ProductEntity 인스턴스를 조립하기 위한 정적 내부 클래스(Static Nested Class)입니다.
    public static class Builder {
        // 객체 생성 전까지 임시로 값을 담아둘 필드들입니다.
        private Long id;
        private String name;
        private int price;
        private AnswerCategory category;

        // ID 값을 설정하고, 메서드 체이닝을 위해 Builder 자신(this)을 다시 반환합니다.
        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        // 상품명을 설정하고, 메서드 체이닝을 위해 Builder 자신(this)을 다시 반환합니다.
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        // 가격을 설정하고, 메서드 체이닝을 위해 Builder 자신(this)을 다시 반환합니다.
        public Builder price(int price) {
            this.price = price;
            return this;
        }

        // 카테고리를 설정하고, 메서드 체이닝을 위해 Builder 자신(this)을 다시 반환합니다.
        public Builder category(AnswerCategory category) {
            this.category = category;
            return this;
        }

        // 설정된 필드값들을 바탕으로 최종 AnswerProductEntity 객체를 생성하여 반환합니다.
        public AnswerProductEntity build() {
            return new AnswerProductEntity(this);
        }
    }
}

// =========================================================================
// [4] 전략 패턴 (AnswerQueryExecutionStrategy 인터페이스 및 구현체)
// =========================================================================
// SQL 쿼리를 실행하는 알고리즘을 캡슐화하기 위한 전략 인터페이스입니다.
interface AnswerQueryExecutionStrategy {
    // 구체적인 실행 방식은 이 메서드를 오버라이드하여 동적으로 정의하게 됩니다.
    void execute(String sql);
}

// 콘솔에 기본 형태 그대로 SQL을 출력해주는 전략 구현체입니다.
class AnswerPrintStrategy implements AnswerQueryExecutionStrategy {
    @Override
    public void execute(String sql) {
        // 전달받은 SQL을 그대로 화면에 출력합니다.
        System.out.println("[SQL 실행 (콘솔출력)] : " + sql);
    }
}

// SQL 문장을 모두 대문자로 치환하여 출력해주는 대문자 특화 실행 전략입니다.
class AnswerUpperCaseStrategy implements AnswerQueryExecutionStrategy {
    @Override
    public void execute(String sql) {
        // String.toUpperCase() 메서드를 이용하여 소문자 쿼리를 대문자로 바꾼 후 출력합니다.
        System.out.println("[SQL 실행 (대문자)] : " + sql.toUpperCase());
    }
}

// =========================================================================
// [5] AnswerSmartOrmEngine 클래스 (싱글톤 및 리플렉션 쿼리 빌더 구현)
// =========================================================================
class AnswerSmartOrmEngine {
    // Eager Initialization 방식을 사용하여 클래스 로딩 시점에 싱글톤 인스턴스를 미리 생성합니다.
    private static final AnswerSmartOrmEngine instance = new AnswerSmartOrmEngine();

    // 동적으로 주입될 SQL 실행 전략을 보관하는 필드입니다.
    private AnswerQueryExecutionStrategy strategy;

    // 싱글톤 패턴의 핵심으로, 외부에서 new AnswerSmartOrmEngine()을 호출하지 못하게 private 생성자를 선언합니다.
    private AnswerSmartOrmEngine() {
        // 기본 전략으로 PrintStrategy를 미리 할당하여 NullPointerException을 방지합니다.
        this.strategy = new AnswerPrintStrategy();
    }

    // 외부에서 유일한 싱글톤 인스턴스를 가져갈 수 있도록 제공하는 글로벌 static 메서드입니다.
    public static AnswerSmartOrmEngine getInstance() {
        return instance;
    }

    // 동적으로 실행 전략을 바꿀 수 있게 해주는 Setter 메서드(의존성 주입)입니다.
    public void setStrategy(AnswerQueryExecutionStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 리플렉션을 통해 객체에서 테이블명 및 컬럼 정보를 읽어 동적 INSERT SQL 쿼리를 완성시킵니다.
     */
    public String generateInsertQuery(Object entity) throws Exception {
        // 1. 전달받은 엔티티 객체의 Class 정보를 가져옵니다.
        Class<?> clazz = entity.getClass();

        // 2. 클래스에 @AnswerTable 어노테이션이 붙어 있는지 확인합니다.
        if (!clazz.isAnnotationPresent(AnswerTable.class)) {
            throw new IllegalArgumentException("엔티티에 @AnswerTable 어노테이션이 존재하지 않습니다.");
        }
        
        // 3. 어노테이션 객체를 꺼내어 설정된 테이블 이름(name)을 획득합니다.
        AnswerTable table = clazz.getAnnotation(AnswerTable.class);
        String tableName = table.name();

        // 컬럼명 리스트와 컬럼에 들어갈 데이터 값 리스트를 임시로 조립할 StringBuilder입니다.
        StringBuilder cols = new StringBuilder();
        StringBuilder vals = new StringBuilder();

        // 4. 해당 클래스에 선언된 모든 필드(private 포함) 목록을 가져옵니다.
        Field[] fields = clazz.getDeclaredFields();
        
        // 5. 각 필드를 순회하며 컬럼으로 매핑할 대상인지 확인합니다.
        for (Field field : fields) {
            // 필드에 @AnswerColumn 어노테이션이 붙어 있는 경우에만 처리합니다.
            if (field.isAnnotationPresent(AnswerColumn.class)) {
                // 필드 매핑 정보를 가지고 있는 @AnswerColumn 어노테이션 인스턴스를 가져옵니다.
                AnswerColumn col = field.getAnnotation(AnswerColumn.class);
                
                // 설정된 컬럼명을 컬럼 빌더에 추가하고 구분 쉼표(,)를 덧붙입니다.
                cols.append(col.name()).append(", ");

                // private 필드에도 직접 접근하여 값을 읽어올 수 있도록 접근 제어 권한을 일시적으로 허용합니다.
                field.setAccessible(true);
                // 전달된 엔티티 인스턴스에서 해당 필드의 실제 값을 리플렉션으로 추출합니다.
                Object value = field.get(entity);

                // SQL 쿼리 문법에 맞게 값의 데이터 타입에 맞춰 포맷팅을 분기합니다.
                if (value == null) {
                    // 값이 비어있다면 SQL 상수인 NULL로 매핑합니다.
                    vals.append("NULL, ");
                } else if (value instanceof String || value instanceof AnswerCategory) {
                    // 문자열 타입이거나 Category Enum 타입인 경우에는 작은따옴표(')로 감싸줍니다.
                    // Enum의 경우 toString()이 상수의 이름(예: "ELECTRONICS")을 리턴하므로 문자열 처리가 필요합니다.
                    vals.append("'").append(value.toString()).append("', ");
                } else {
                    // 숫자 등 다른 타입은 별도의 처리 없이 값 그대로 문자열로 표현합니다.
                    vals.append(value).append(", ");
                }
            }
        }

        // 6. 루프가 끝난 뒤 맨 마지막 컬럼/값 뒤에 남아있는 불필요한 쉼표(", ")를 잘라냅니다.
        if (cols.length() > 0) {
            cols.setLength(cols.length() - 2);
            vals.setLength(vals.length() - 2);
        }

        // 7. 최종 완성된 형태인 "INSERT INTO 테이블명 (컬럼1, 컬럼2...) VALUES (값1, 값2...);" 형식으로 쿼리를 반환합니다.
        return String.format("INSERT INTO %s (%s) VALUES (%s);", tableName, cols, vals);
    }

    /**
     * 동적으로 생성된 쿼리를 생성하고 주입된 전략을 사용해 실행 시뮬레이션을 완료합니다.
     */
    public void runQuery(Object entity) {
        try {
            // 리플렉션 기반 쿼리 생성 메서드를 호출합니다.
            String sql = generateInsertQuery(entity);
            // 주입받은 전략이 존재하면 execute 메서드로 실행을 위임합니다.
            if (strategy != null) {
                strategy.execute(sql);
            }
        } catch (Exception e) {
            // 예외가 발생할 경우 에러 내용을 콘솔에 알기 쉽게 표시해 줍니다.
            System.err.println("ORM 실행 중 에러 발생: " + e.getMessage());
        }
    }
}

// =========================================================================
// [6] 메인 실행 클래스
// =========================================================================
public class MiniProjectAnswer {
    public static void main(String[] args) {
        // 1. 빌더 패턴의 메서드 체이닝을 활용해 필요한 필드값을 세팅하며 AnswerProductEntity 객체를 생성합니다.
        AnswerProductEntity prod = AnswerProductEntity.builder()
                .id(1L)
                .name("노트북")
                .price(1500000)
                .category(AnswerCategory.ELECTRONICS)
                .build();

        // 2. 글로벌 전역에서 단 하나만 존재하는 ORM 엔진의 싱글톤 인스턴스를 안전하게 가져옵니다.
        AnswerSmartOrmEngine engine = AnswerSmartOrmEngine.getInstance();

        // 3. 별도의 설정을 변경하지 않았으므로, 기본 장착된 기본 출력 전략(AnswerPrintStrategy)으로 시뮬레이션을 실행합니다.
        System.out.println("--- 1. 기본 출력 전략 ---");
        engine.runQuery(prod);

        // 4. 실행 중에 대문자 변환 출력 전략(AnswerUpperCaseStrategy)으로 dynamic하게 전략을 교체(Dependency Injection)합니다.
        System.out.println("\n--- 2. 대문자 출력 전략으로 동적 교체 ---");
        engine.setStrategy(new AnswerUpperCaseStrategy());
        // 교체된 전략을 바탕으로 동일한 엔티티를 활용해 쿼리를 다시 실행합니다.
        engine.runQuery(prod);
    }
}
