package week07.day6;

/**
 * [종합 미니 프로젝트 가이드 - 신규] Week 07 Day 6
 * 「 람다와 스트림 기반의 주문 데이터 분석 시스템 」
 * 
 * [목적]
 *   Week 07에서 배운 자바 함수형 프로그래밍 개념(람다식, 표준 함수형 인터페이스, 스트림 API, Optional, 메서드 참조)을
 *   모두 활용하여 대용량 주문 데이터를 분석하고 통계를 내는 시스템을 구축합니다.
 * 
 * [활용 개념 — Day별 대응]
 *   - Day 1 & Day 2 (람다식 & 표준 함수형 인터페이스):
 *       주문 필터링 조건 정의 시 Predicate<Order> 사용.
 *       주문 정보를 원하는 포맷의 문자열로 변환할 때 Function<Order, String> 사용.
 *       람다식 코드를 직접 구현하여 함수형 인터페이스의 익명 구현체 정의.
 *   - Day 3 (스트림 API 기초):
 *       List<Order>를 stream()으로 변환하여 filter(), map(), forEach(), collect() 등 기초 파이프라인 적용.
 *   - Day 4 (스트림 API 심화):
 *       주문 가격의 총합을 구할 때 reduce() 또는 mapToDouble().sum() 활용.
 *       주문을 카테고리별로 묶어 통계를 내기 위해 Collectors.groupingBy() 사용.
 *       주문 금액 기준 정렬 시 sorted() 및 Comparator 활용.
 *   - Day 5 (Optional & 메서드 참조):
 *       가장 금액이 큰 주문을 찾을 때 Optional<Order>를 반환받아 orElse() 또는 ifPresent()로 안전하게 처리.
 *       메서드 참조(예: Order::getPrice, System.out::println)를 활용해 가독성 높은 스트림 코드 작성.
 * 
 * [상세 요구사항]
 *   1. Order 클래스 설계:
 *      - 필드: private String orderId, private String customerName, private String category, private double price
 *      - 생성자 및 Getter 구현
 *      - toString() 구현
 *   2. 메인 프로그램 흐름:
 *      - 5개 이상의 테스트용 Order 객체를 리스트에 등록합니다.
 *      - 아래의 분석 미션을 스트림 파이프라인을 사용하여 수행하고 콘솔에 출력합니다.
 *      - [미션 1] 전자제품("Electronics") 카테고리의 모든 주문을 필터링하여 출력 (람다식 Predicate 사용).
 *      - [미션 2] 전체 주문의 총 결제 금액 계산 (reduce() 혹은 mapToDouble().sum() 사용).
 *      - [미션 3] 주문 금액 기준 내림차순 정렬하여 상위 3개의 주문만 추출 및 출력 (메서드 참조 활용).
 *      - [미션 4] 카테고리별로 주문 목록 그룹핑하여 출력 (Collectors.groupingBy() 사용).
 *      - [미션 5] 가장 높은 주문 금액을 가진 주문을 찾아 출력. 결과는 Optional<Order>로 받아서, 
 *                존재할 경우 출력하고 없을 경우 "주문 내역이 없습니다."를 기본값으로 출력하도록 처리.
 */
public class MiniProjectGuide_New {
}
