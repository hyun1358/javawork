package week11.day2;

// 전략(Strategy) 패턴을 활용한 결제 시스템 예제입니다.
public class Answer2 {
    // 메인 메서드
    public static void main(String[] args) {
        PaymentSystem ps = new PaymentSystem();
        // 카카오페이 결제 전략을 설정하고 결제를 수행합니다.
        ps.setStrategy(new KakaoPay());
        ps.pay(1000);
        // 네이버페이 결제 전략으로 변경하고 결제를 수행합니다. (동적 변경)
        ps.setStrategy(new NaverPay());
        ps.pay(2000);
    }

    // 결제 전략 인터페이스 (Strategy)
    interface PayStrategy {
        void pay(int amt); // 결제 기능을 정의
    }

    // 카카오페이 결제 전략을 구현한 구체 클래스 (ConcreteStrategy)
    static class KakaoPay implements PayStrategy {
        @Override
        public void pay(int amt) {
            System.out.println("카카오페이 " + amt + "원");
        }
    }

    // 네이버페이 결제 전략을 구현한 구체 클래스 (ConcreteStrategy)
    static class NaverPay implements PayStrategy {
        @Override
        public void pay(int amt) {
            System.out.println("네이버페이 " + amt + "원");
        }
    }

    // 결제를 수행하는 시스템 컨텍스트 (Context)
    static class PaymentSystem {
        PayStrategy strategy; // 동적으로 변경 가능한 전략 객체

        // 결제 전략을 설정(주입)하는 메서드
        void setStrategy(PayStrategy s) {
            strategy = s;
        }

        // 설정된 전략에 위임하여 실제 결제를 수행하는 메서드
        void pay(int amt) {
            strategy.pay(amt);
        }
    }
}
