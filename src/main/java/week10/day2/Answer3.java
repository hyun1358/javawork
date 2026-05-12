package week10.day2;

public class Answer3 {
    public static void main(String[] args) throws Exception {
        BankAccount acc = new BankAccount();
        Runnable r = () -> {
            for (int i = 0; i < 10; i++) acc.withdraw(100);
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("최종 잔액: " + acc.getBalance());
    }
}

class BankAccount {
    private int balance = 2000;

    public synchronized void withdraw(int amt) {
        balance -= amt;
    }

    public int getBalance() {
        return balance;
    }
}
