package week05.day3;

public class Answer3 {
    public static void main(String[] args) {
        // BankAccount 객체를 생성하여 새로운 계좌를 만듭니다.
        BankAccount acc = new BankAccount();
        
        // 입금 메서드를 호출하여 계좌 잔액을 증가시킵니다.
        acc.deposit(1000);
        
        // 출금 메서드를 호출하여 계좌 잔액을 감소시킵니다.
        acc.withdraw(500);
        
        // getter 메서드를 사용하여 현재 계좌 잔액을 조회하고 출력합니다.
        System.out.println("잔액: " + acc.getBalance());
    }
}

// [클래스 설명] BankAccount 클래스는 은행 계좌의 잔액(상태)과 입금/출금 동작을 캡슐화한 클래스입니다.
class BankAccount {
    // [필드 설명] 계좌 잔액을 임의로 수정할 수 없도록 private으로 제한합니다.
    private int balance;

    // [메서드 설명] 현재 잔액을 확인하기 위한 getter 메서드입니다.
    public int getBalance() {
        return balance;
    }

    // [메서드 설명] 외부에서 전달받은 금액(amount)을 현재 잔액에 안전하게 추가하는 입금 메서드입니다.
    public void deposit(int amount) {
        this.balance += amount;
    }

    // [메서드 설명] 출금 전 잔액이 충분한지 확인하는 검증 로직이 포함된 출금 메서드입니다.
    public void withdraw(int amount) {
        // [로직 설명] 출금하려는 금액보다 잔액이 크거나 같을 때만 차감하고, 그렇지 않으면 경고를 출력합니다.
        if (balance >= amount) this.balance -= amount;
        else System.out.println("잔액 부족");
    }
}
