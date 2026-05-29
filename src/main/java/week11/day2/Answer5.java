package week11.day2;

// 전략(Strategy) 패턴을 익명 클래스 대신 람다식으로 간결하게 구현하는 예제입니다.
public class Answer5 {
    // 메인 메서드
    public static void main(String[] args) {
        PaymentSystem ps = new PaymentSystem();
        // PayStrategy 인터페이스의 구현체를 별도의 클래스로 만들지 않고 람다식을 사용해 즉석에서 전달합니다.
        ps.setStrategy(amt -> System.out.println("토스페이 " + amt + "원"));
        // 전달된 람다식(전략)을 실행합니다.
        ps.pay(5000);
    }

    // 단일 추상 메서드를 가지는 함수형 인터페이스 역할을 하는 전략 인터페이스
    interface PayStrategy {
        void pay(int amt);
    }

    // 결제를 처리하는 시스템 (Context)
    static class PaymentSystem {
        PayStrategy strategy;

        // 외부로부터 구체적인 결제 전략을 주입받습니다.
        void setStrategy(PayStrategy s) {
            strategy = s;
        }

        // 주입받은 전략을 사용하여 결제를 실행합니다.
        void pay(int amt) {
            strategy.pay(amt);
        }
    }
}
