package week11.day2;

public class Answer2 {
    public static void main(String[] args) {
        PaymentSystem ps = new PaymentSystem();
        ps.setStrategy(new KakaoPay());
        ps.pay(1000);
        ps.setStrategy(new NaverPay());
        ps.pay(2000);
    }
}

interface PayStrategy {
    void pay(int amt);
}

class KakaoPay implements PayStrategy {
    public void pay(int amt) {
        System.out.println("카카오페이 " + amt + "원");
    }
}

class NaverPay implements PayStrategy {
    public void pay(int amt) {
        System.out.println("네이버페이 " + amt + "원");
    }
}

class PaymentSystem {
    PayStrategy strategy;

    void setStrategy(PayStrategy s) {
        strategy = s;
    }

    void pay(int amt) {
        strategy.pay(amt);
    }
}
