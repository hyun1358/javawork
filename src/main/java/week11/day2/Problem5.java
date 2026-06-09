package week11.day2;

/**
 * [연습 문제 5] 람다를 이용한 전략
 * 문제: 결제 전략(Problem2)을 별도 클래스 대신 람다식으로 주입하여 실행해보세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        Payment payment = new Payment("삼성페이");
        payment.setPaymentStrategy(amount -> System.out.println("[" + payment.payname + "]" + "결재금액: " + amount));
        payment.pay(50000);

        payment.setPayname("카카오페이");
        payment.setPaymentStrategy(amount -> System.out.println("[" + payment.payname + "]" + "결재금액: " + amount));
        payment.pay(50000);

    }

    interface PaymentStrategy
    {
        void pay(int amount);
    }

    static class Payment
    {
        PaymentStrategy paymentStrategy;
        String payname;

        Payment(String payname) { this.payname = payname;}

        void setPayname(String payname) { this.payname = payname;}

        void setPaymentStrategy(PaymentStrategy p ) {this.paymentStrategy = p;}

        void pay(int amount)
        {
            paymentStrategy.pay(amount);
        }
    }
}
