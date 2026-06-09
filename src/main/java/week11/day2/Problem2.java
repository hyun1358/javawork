package week11.day2;

/**
 * [연습 문제 2] 결제 전략 패턴
 * 문제: 카카오페이, 네이버페이 결제 전략 클래스를 만들고 교체하여 결제되게 구현하세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        Payments pay = new Payments();

        pay.setPayStrategy(new SamsungPayStrategy());
        pay.pay(50000);

        pay.setPayStrategy(new KakaoPayStrategy());
        pay.pay(5000);
    }

    interface PayStrategy
    {
        void pay(int amount);
    }

    static class SamsungPayStrategy implements PayStrategy
    {
        @Override
        public void pay(int amount)
        {
            System.out.println("[삼성페이] 결제금액: "+amount+"원");
        }
    }

    static class KakaoPayStrategy implements PayStrategy
    {
        @Override
        public void pay(int amount)
        {
            System.out.println("[카카오] 결제금액: "+amount+"원");
        }
    }

    static class Payments
    {
        PayStrategy payStrategy;

        void setPayStrategy(PayStrategy p)
        {
            this.payStrategy = p;
        }

        void pay(int amount) { payStrategy.pay(amount); }
    }
}
