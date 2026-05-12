package week05.day3;

public class Answer3 {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        acc.deposit(1000);
        acc.withdraw(500);
        System.out.println("잔액: " + acc.getBalance());
    }
}

class BankAccount {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if (balance >= amount) this.balance -= amount;
        else System.out.println("잔액 부족");
    }
}
