package week11.day2;

/**
 * [학습 예제 2] Week 11 Day 2 — 전략 패턴 & 옵저버 패턴 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 2] 전략 패턴 (Strategy Pattern)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 알고리즘(행동)을 인터페이스로 추상화하여, 런타임에 교체 가능하게 설계
 *  - Context 클래스는 Strategy 인터페이스만 알고, 구체 구현은 모름
 *
 * [문제별 학습 목표]
 * - 문제 2: 전략 패턴 — 카카오페이/네이버페이 결제 전략 교체
 */
public class Example2 {
    public static void main(String[] args) {
        // ─────────────────────────────────────────────
        // Lab 2: 전략 패턴 — 결제 전략 (→ 문제 2 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 2: 전략 패턴 — 결제 ===");
        PaymentContext payment = new PaymentContext();

        payment.setStrategy(new KakaoPay()); // 카카오페이로 설정
        payment.pay(15000);

        payment.setStrategy(new NaverPay()); // 네이버페이로 교체
        payment.pay(30000);
    }

    // ─── 전략 패턴: 결제 ───────────────────────────────────
    interface PaymentStrategy {
        void pay(int amount);
    }

    static class KakaoPay implements PaymentStrategy {
        public void pay(int amount) {
            System.out.println("카카오페이로 " + amount + "원 결제");
        }
    }

    static class NaverPay implements PaymentStrategy {
        public void pay(int amount) {
            System.out.println("네이버페이로 " + amount + "원 결제");
        }
    }

    static class PaymentContext {
        private PaymentStrategy strategy;

        public void setStrategy(PaymentStrategy s) { this.strategy = s; }

        public void pay(int amount) { strategy.pay(amount); }
    }
}
