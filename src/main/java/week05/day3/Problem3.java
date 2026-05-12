package week05.day3;

/**
 * [연습 문제 3] 은행 계좌 캡슐화
 * 문제: BankAccount 클래스에 private int balance(잔액) 필드를 만들고
 * deposit(입금), withdraw(출금) 메서드로만 잔액을 변경할 수 있게 하세요.
 */
public class Problem3 {
    public static void main(String[] args) {
        // TODO: 직접 balance를 수정할 수 없는지 확인하고 메서드로 조작하세요.
        BankAccount bank = new BankAccount();
        System.out.println(bank.getBalance());
        bank.deposit(10000);
        bank.withdraw(-150000);
        bank.withdraw(1000);
        System.out.println(bank.getBalance());
    }

    static class BankAccount {
        private int balance = 0;

        void deposit(int money) {
            this.balance += money;
        }

        void withdraw(int money) {
            if (money <= 0) {
                System.out.println("출금은 0보다 금액이 커야합니다.");
            } else if (this.balance < money) {
                System.out.println("출금 금액이 보유잔앤보다 많습니다.");
            } else {
                this.balance -= money;
            }
        }

        int getBalance() {
            return this.balance;
        }
    }
}
