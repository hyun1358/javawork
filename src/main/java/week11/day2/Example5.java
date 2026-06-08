package week11.day2;

/**
 * [학습 예제 5] Week 11 Day 2 — 전략 패턴 & 옵저버 패턴 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 5] 전략 패턴 (Strategy Pattern)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 람다식으로도 주입 가능 (함수형 인터페이스면 OK)
 *
 * [문제별 학습 목표]
 * - 문제 5: 람다로 전략 주입 — 별도 클래스 없이 람다식으로 전략 구현
 */
public class Example5 {
    public static void main(String[] args) {
        // ─────────────────────────────────────────────
        // Lab 5: 람다로 전략 주입 (→ 문제 5 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 5: 람다로 전략 주입 ===");
        PaymentContext lambdaPayment = new PaymentContext();

        // 별도 클래스 없이 람다식으로 전략 주입
        lambdaPayment.setStrategy(amount -> System.out.println("삼성페이로 " + amount + "원 결제"));
        lambdaPayment.pay(50000);

        lambdaPayment.setStrategy(amount -> System.out.println("애플페이로 " + amount + "원 결제"));
        lambdaPayment.pay(12000);
    }

    // ─── 전략 패턴: 결제 ───────────────────────────────────
    interface PaymentStrategy {
        void pay(int amount);
    }

    static class PaymentContext {
        private PaymentStrategy strategy;

        public void setStrategy(PaymentStrategy s) { this.strategy = s; }

        public void pay(int amount) { strategy.pay(amount); }
    }
}
