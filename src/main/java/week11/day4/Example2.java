package week11.day4;

/**
 * [학습 예제 2] Week 11 Day 4 — Enum & 어노테이션 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 2] Enum 상태 머신
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - Enum 상수에 메서드를 정의하여 객체의 상태 전이를 관리
 *
 * [문제별 학습 목표]
 * - 문제 2: Enum 상태 머신 — OrderStatus
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("\n=== Lab 2: Enum 상태 머신 — OrderStatus ===");
        OrderStatus status = OrderStatus.PENDING;
        System.out.println("초기 상태: " + status);

        status = status.next(); // PENDING → PAID
        System.out.println("다음 상태: " + status);

        status = status.next(); // PAID → SHIPPED
        System.out.println("다음 상태: " + status);

        status = status.next(); // SHIPPED → 더 이상 없음 (자기 자신 유지)
        System.out.println("다음 상태: " + status);

        status = status.next(); // SHIPPED → 더 이상 없음 (자기 자신 유지)
        System.out.println("다음 상태: " + status);
    }

    enum OrderStatus {
        PENDING, PAID, SHIPPED, DELIVERED;
        public OrderStatus next() {
            OrderStatus[] values = OrderStatus.values();
            int next = this.ordinal() + 1;
            return next < values.length ? values[next] : this;
        }
    }
}
