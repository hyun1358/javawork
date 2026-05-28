package week11.day2;

public class Answer5 {
    public static void main(String[] args) {
        PaymentSystem ps = new PaymentSystem();
        // 별도 클래스 대신 람다로 즉석에서 전략 주입
        ps.setStrategy(amt -> System.out.println("토스페이 " + amt + "원"));
        ps.pay(5000);
    }

    interface PayStrategy {
        void pay(int amt);
    }

    static class PaymentSystem {
        PayStrategy strategy;

        void setStrategy(PayStrategy s) {
            strategy = s;
        }

        void pay(int amt) {
            strategy.pay(amt);
        }
    }
}
