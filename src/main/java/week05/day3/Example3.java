package week05.day3;

/**
 * [학습 예제 3] Week 05 Day 3 — 접근 제어자와 캡슐화
 * 
 * [학습 핵심 이론: 객체의 자율성과 정보 은닉]
 * 3. 캡슐화 (Encapsulation)와 Getter/Setter:
 *    - 안전하고 검증된 통로인 public 메서드를 통해서만 제어할 수 있도록 캡슐화합니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: BankAccount 클래스 입출금 비즈니스 로직 보호 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(10000);
        account.withdraw(150000); // 잔액 부족 에러 발생
        account.withdraw(4000);   // 정상 출금
        System.out.println("최종 계좌 잔액: " + account.getBalance());
    }

    // Problem 3: BankAccount 클래스 안전 입출금
    static class BankAccount {
        private int balance = 0; // 잔액은 외부 직접 수정 금지 (private)

        public int getBalance() {
            return this.balance;
        }

        public void deposit(int money) {
            if (money <= 0) {
                System.out.println("입금 오류: 입금액은 0보다 커야 합니다.");
                return;
            }
            this.balance += money;
            System.out.println(money + "원 입금 완료. (현재 잔액: " + this.balance + "원)");
        }

        public void withdraw(int money) {
            if (money <= 0) {
                System.out.println("출금 오류: 출금액은 0보다 커야 합니다.");
            } else if (this.balance < money) {
                System.out.println("출금 오류: 출금 금액이 보유 잔액보다 많습니다. (잔액 부족)");
            } else {
                this.balance -= money;
                System.out.println(money + "원 출금 완료. (현재 잔액: " + this.balance + "원)");
            }
        }
    }
}
