package week08.day6;

/**
 * [종합 미니 프로젝트 가이드 - 신규] Week 08 Day 6
 * 「 멀티스레드 기반 티켓 실시간 예매 및 랭킹 관리 시스템 」
 * 
 * [목적]
 *   Week 08에서 배운 멀티스레딩 및 동기화, 스레드 풀, 날짜/시간 API, 그리고 유틸리티 클래스들을 
 *   모두 연계하여 실시간 동시성 제어 예매 엔진을 시뮬레이션합니다.
 * 
 * [활용 개념 — Day별 대응]
 *   - Day 1 (스레드 기초):
 *       예매를 시도하는 다수의 사용자 요청을 Runnable 인터페이스 구현 클래스(ReservationTask)로 설계하여 스레드화.
 *   - Day 2 (동기화):
 *       한정된 좌석(남은 티켓)을 공유 자원으로 설정하고, 여러 스레드가 동시에 예매할 때 데이터 무결성을 위해 
 *       synchronized 키워드를 사용해 한 번에 하나의 스레드만 예매하도록 제어.
 *   - Day 3 (스레드 풀):
 *       스레드를 직접 생성하여 생성 오버헤드를 유발하지 않고, ExecutorService 및 Executors.newFixedThreadPool()을 
 *       사용해 일정한 크기의 스레드 풀로 10개 이상의 병렬 예매 작업을 효율적으로 관리 및 수행.
 *   - Day 4 (날짜/시간 API):
 *       예매가 성공한 시점의 날짜/시간을 LocalDateTime과 DateTimeFormatter("yyyy-MM-dd HH:mm:ss.SSS")로 출력.
 *       예매가 시작하고 전체 스레드 풀 작업이 끝날 때까지 걸린 전체 소요 시간을 Duration으로 정밀하게 계산.
 *   - Day 5 (유틸리티):
 *       예매가 성공하면 Random 클래스를 사용해 좌석 번호(1~50 범위)를 무작위로 배정.
 *       예매 완료된 리스트를 Collections.sort() 및 익명 클래스/람다 Comparator를 사용해 고객 이름 오름차순으로 정렬하여 출력.
 * 
 * [상세 요구사항]
 *   1. TicketReservation 클래스 설계:
 *      - 필드: String customerName, LocalDateTime reservationTime, int seatNumber
 *      - 생성자 및 Getter/Setter 구현
 *      - toString() 오버라이딩 (고객명, 예매 시각, 좌석번호 출력)
 *   2. TicketBooth 클래스 설계 (공유 자원):
 *      - 필드: private int remainingTickets = 5; (총 5장의 티켓만 선착순 판매)
 *      - 리스트: List<TicketReservation> successList = new ArrayList<>();
 *      - 메서드: 
 *        * public synchronized boolean reserve(String customerName) : 
 *          남은 티켓이 있으면 remainingTickets를 1 감소시키고, Random을 통해 좌석 번호를 생성한 뒤 
 *          TicketReservation 객체를 생성하여 successList에 담고 true 반환. 남은 티켓이 없으면 false 반환.
 *   3. ReservationTask (Runnable 구현체) 설계:
 *      - 필드: String name, TicketBooth booth
 *      - run() 구현: booth.reserve(name) 호출 후 성공 시 "[이름] 예매 성공!", 실패 시 "[이름] 예매 실패(매진)" 출력.
 *   4. 메인 프로그램 흐름:
 *      - TicketBooth 인스턴스 생성
 *      - ExecutorService 스레드 풀 생성 (예: 크기 3)
 *      - 10명의 고객("고객1" ~ "고객10")의 ReservationTask를 스레드 풀에 submit()하여 병렬 실행.
 *      - 모든 스레드가 종료될 때까지 awaitTermination()을 통해 대기하며 전체 실행 소요 시간을 Duration으로 구함.
 *      - 예매 완료된 successList를 Collections.sort()를 사용하여 고객 이름순으로 정렬한 뒤 출력.
 */
public class MiniProjectGuide_New {
}
