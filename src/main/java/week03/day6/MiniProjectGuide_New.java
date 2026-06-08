package week03.day6;

/**
 * [종합 미니 프로젝트 가이드 - 신규] Week 03 Day 6
 * 「 스마트 쇼핑몰 회원 및 포인트 관리 시스템 」
 * 
 * [목적]
 *   Week 03에서 배운 자바 객체 지향 및 문자열/래퍼 클래스 개념(상속, 오버라이딩, Object 클래스, String 메서드, 래퍼 클래스)을
 *   모두 활용하여 쇼핑몰 회원 관리 시스템을 구축합니다.
 * 
 * [활용 개념 — Day별 대응]
 *   - Day 1 (상속 기초):
 *       일반 회원(Member) 클래스를 정의하고, 이를 상속받는 VipMember 클래스를 extends를 사용해 정의. super 키워드로 부모 생성자 호출.
 *   - Day 2 (상속 심화):
 *       포인트 계산 메서드 calculatePoint(int price)를 정의하고, VipMember 클래스에서 이를 오버라이딩(@Override)하여 
 *       일반 회원(1% 적립)보다 높은 포인트 적립률(5% 적립)을 적용.
 *   - Day 3 (Object 클래스):
 *       Member 클래스에서 toString()을 오버라이딩하여 회원 정보(아이디, 이름, 등급, 포인트)를 서식에 맞춰 출력.
 *       equals()와 hashCode()를 오버라이딩하여 회원 아이디(id)가 같으면 동일한 회원으로 판별되도록 구현.
 *   - Day 4 (String 클래스 심화):
 *       회원 가입 정보 입력 시 쉼표(,)로 구분된 단일 문자열(예: "user123,홍길동,VIP")을 입력받아 split()으로 파싱.
 *       이름 출력 시 substring()과 StringBuilder를 활용하여 가운데 글자를 '*'로 마스킹(예: 홍*동) 처리하여 출력.
 *   - Day 5 (래퍼 클래스와 형변환):
 *       입력받은 구매 금액 문자열을 Integer.parseInt()를 이용해 정수형으로 변환 후 계산 처리.
 *       포인트를 객체(Integer)로 다룰 때의 오토박싱/언박싱 확인.
 * 
 * [상세 요구사항]
 *   1. Member 클래스 (부모) 설계:
 *      - 필드: private String id, private String name, protected int point
 *      - 생성자: id, name을 매개변수로 받아 초기화
 *      - 메서드: 
 *        * public void calculatePoint(int price): price의 1%를 point에 누적
 *        * toString(): "아이디: [id], 이름: [마스킹된 이름], 포인트: [point]P (일반 회원)" 형태로 반환
 *        * equals/hashCode: id 기준 비교
 *   2. VipMember 클래스 (자식) 설계:
 *      - Member 상속
 *      - 생성자: super(id, name) 호출
 *      - 메서드 오버라이딩:
 *        * calculatePoint(int price): price의 5%를 point에 누적
 *        * toString(): 부모의 toString()을 활용하거나 재정의하여 "VIP 회원"임을 명시
 *   3. 메인 프로그램 흐름:
 *      - 쉼표로 구분된 회원 가입 데이터를 입력받습니다. (예: "user01,홍길동,VIP" 또는 "user02,이순신,일반")
 *      - split()으로 정보를 추출하고 회원 등급에 맞게 Member 또는 VipMember 객체를 생성하여 배열(Member[] members)에 저장합니다.
 *      - 회원이 정상 등록되었는지 검증하기 위해 동일한 id로 입력을 시도하여 equals() 작동 여부를 확인합니다.
 *      - 등록된 회원에 대해 구매 금액(문자열 형태)을 입력받아 Integer.parseInt()로 변환 후 포인트를 계산합니다.
 *      - 최종적으로 등록된 모든 회원들의 정보를 toString()을 통해 가독성 높은 이름 마스킹 형태로 출력합니다.
 */
public class MiniProjectGuide_New {
}
