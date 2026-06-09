package week11.day6;

/**
 * [종합 미니 프로젝트 가이드] Week 11 Day 6
 * 「 디자인 패턴 기반의 플러그형 스마트 ORM 엔진 」
 * 
 * [미션]
 *   Week 11에서 배운 디자인 패턴(싱글톤, 전략, 빌더), Enum 심화, 그리고 리플렉션/어노테이션 기술을
 *   하나의 완성도 높은 ORM(Object-Relational Mapping) 시뮬레이션 시스템으로 통합 구현합니다.
 * 
 * [활용 개념 — Day별 대응]
 *   - Day 1 (싱글톤 패턴):
 *       객체 매핑 및 쿼리 빌드 처리를 도맡는 `SmartOrmEngine` 클래스를 프로그램 전역에서
 *       단 하나만 존재하고 안전하게 공유할 수 있는 싱글톤(Eager 또는 Lazy)으로 설계합니다.
 *   - Day 2 (전략 패턴):
 *       생성된 SQL 쿼리를 실행하는 처리 방식을 상황에 따라 동적으로 갈아끼울 수 있도록 
 *       `QueryExecutionStrategy` 인터페이스를 선언하고, 콘솔에 바로 출력하는 `PrintStrategy`와 
 *       대문자로 가공하여 출력하는 `UpperCaseStrategy` 등을 구현하여 적용합니다.
 *   - Day 3 (빌더 패턴):
 *       다양한 필드(id, name, price, category)를 갖는 `ProductEntity` 객체를 가독성 높고 안전하게
 *       단계별로 생성할 수 있도록 내부 빌더 클래스(Builder Pattern)를 정의합니다.
 *   - Day 4 (Enum 심화):
 *       상품 카테고리를 표현하는 `Category` Enum을 선언하고, 단순 이름 상수를 넘어 
 *       내부에 한글 설명 필드(`koreanName`)와 생성자를 지닌 Enum 심화 형태로 설계합니다.
 *   - Day 5 (리플렉션 및 커스텀 어노테이션):
 *       `@Table(name="테이블명")`과 `@Column(name="컬럼명")` 커스텀 어노테이션을 선언하고, 
 *       싱글톤 ORM 엔진이 객체를 받아 리플렉션으로 테이블 및 컬럼 정보를 파싱해 동적으로 INSERT 쿼리를 빌드합니다.
 * 
 * [상세 요구사항 및 클래스 설계]
 *   1. 커스텀 어노테이션:
 *      - `@Table`: 클래스 타겟, 런타임 유지. String name() 엘리먼트 가짐.
 *      - `@Column`: 필드 타겟, 런타임 유지. String name() 엘리먼트 가짐.
 *   2. Category Enum (Enum 심화):
 *      - 상수: ELECTRONICS("가전제품"), FOOD("식품"), FASHION("의류")
 *      - 필드 및 생성자: private final String koreanName, 생성자(String) 구현
 *      - 메서드: getKoreanName() 구현
 *   3. ProductEntity 클래스 (빌더 적용):
 *      - 어노테이션 부여: @Table(name = "products")
 *      - 필드: @Column(name = "prod_id") private Long id;
 *             @Column(name = "prod_name") private String name;
 *             @Column(name = "prod_price") private int price;
 *             @Column(name = "prod_category") private Category category;
 *      - 생성자는 private으로 감추고, 내부 정적 클래스인 `Builder`를 구현하여 객체를 생성하게 합니다.
 *   4. QueryExecutionStrategy 인터페이스 및 구현체 (전략 패턴):
 *      - interface QueryExecutionStrategy: void execute(String sql) 메서드 정의.
 *      - class PrintStrategy implements QueryExecutionStrategy: "[SQL 실행] : " + sql 출력.
 *      - class UpperCaseStrategy implements QueryExecutionStrategy: "[SQL 실행 (대문자)] : " + sql.toUpperCase() 출력.
 *   5. SmartOrmEngine 클래스 (싱글톤 + 리플렉션):
 *      - Eager 또는 Lazy 싱글톤 패턴으로 단 하나의 instance만 생성 제한.
 *      - public String generateInsertQuery(Object entity) throws Exception
 *        * 리플렉션으로 객체의 Class를 읽어 @Table 이름 추출.
 *        * 선언된 필드들 중 @Column이 붙은 필드를 순회하며 컬럼명과 값을 수집.
 *        * Category Enum 값인 경우 `name()` 또는 `getKoreanName()` 등이 정상적으로 문자열로 기록되도록 처리.
 *        * 최종 완성된 "INSERT INTO 테이블명 (컬럼들) VALUES (값들);" 포맷의 쿼리 리턴.
 *      - public void setStrategy(QueryExecutionStrategy strategy)
 *        * 사용할 전략을 주입받는 필드 및 Setter 구현.
 *      - public void runQuery(Object entity)
 *        * generateInsertQuery()를 호출해 쿼리를 빌드한 후, 주입받은 전략(`execute`)을 호출해 쿼리 실행 시뮬레이션을 완료.
 */
public class MiniProjectGuide {
}
