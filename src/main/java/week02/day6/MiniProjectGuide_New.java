package week02.day6;

/**
 * [종합 미니 프로젝트 가이드 - 신규] Week 02 Day 6
 * 「 카페 키오스크 및 매출 관리 시스템 」
 * 
 * [목적]
 *   Week 02에서 배운 객체지향 기초 개념(클래스, 메서드, 오버로딩, 가변인자, 캡슐화, static, final)을
 *   모두 활용하여 카페 운영 프로그램을 작성합니다.
 * 
 * [활용 개념 — Day별 대응]
 *   - Day 1 (메서드 기초):
 *       메뉴 출력, 영수증 출력, 총액 계산 등의 기능을 별도 메서드로 정의하여 main 메서드의 결합도를 낮춥니다.
 *   - Day 2 (메서드 오버로딩 & 가변 인자):
 *       가변 인자(varargs)를 활용해 매장에 한 번에 여러 상품을 등록하는 addProducts(Product... products) 메서드 구현.
 *       할인액 계산 시, 할인율(double rate)을 적용하는 메서드와 고정 금액(int amount)을 할인하는 오버로딩 메서드 구현.
 *   - Day 3 (클래스와 객체):
 *       상품을 나타내는 Product 클래스를 정의하고 생성자(constructor) 및 this 키워드를 사용하여 필드 초기화.
 *   - Day 4 (접근제어자와 캡슐화):
 *       Product의 필드(name, price)를 private으로 지정하고 Getter/Setter 제공.
 *       Setter에서 가격이 음수(< 0)가 되지 않도록 검증 로직 구현.
 *   - Day 5 (static과 final):
 *       가게 이름(STORE_NAME)을 static final 상수로 정의.
 *       누적 매출액(totalSales)을 모든 인스턴스가 공유하는 static 변수로 선언하고, 이를 조회하는 static 메서드 구현.
 * 
 * [상세 요구사항]
 *   1. Product 클래스 설계:
 *      - 필드: private String name, private int price
 *      - 생성자: name, price를 전달받아 초기화
 *      - Getter/Setter: price 세팅 시 0 미만인 경우 0으로 자동 세팅되도록 캡슐화 적용
 *   2. 키오스크 프로그램 (메인 클래스):
 *      - static final String STORE_NAME = "자바 자바 카페"; 정의
 *      - static int totalSales = 0; 으로 누적 매출 관리
 *      - 가변인자를 사용하는 메서드: static void addProducts(Product[] menuList, Product... products) 
 *        (전달받은 가변 인자들을 메뉴 배열에 차례로 저장)
 *      - 오버로딩을 사용하는 메서드:
 *        * static double calculateDiscount(int total, double rate): 총액에서 비율(rate, 예: 0.1) 할인액 계산
 *        * static int calculateDiscount(int total, int amount): 총액에서 고정 금액 할인액 계산
 *   3. 실행 흐름:
 *      - 프로그램 시작 시 메뉴판 상품 3가지를 가변 인자 메서드를 통해 메뉴판 배열에 등록합니다.
 *      - 사용자로부터 메뉴 주문(메뉴 번호, 주문 수량)을 받습니다.
 *      - 주문 완료 시, 할인 방식을 선택받습니다 (1. 10% 비율 할인, 2. 1,000원 고정 할인).
 *      - 오버로딩된 할인 메서드를 호출해 최종 결제 금액을 산출하고 영수증을 출력합니다.
 *      - 결제 금액은 가게의 총 매출액(totalSales)에 static으로 누적됩니다.
 *      - '종료' 전까지 주문을 계속 받을 수 있고, 종료 시 누적된 총 매출액을 출력합니다.
 */
public class MiniProjectGuide_New {
}
