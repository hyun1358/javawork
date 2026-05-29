package week10.day2;

/**
 * 객체의 인스턴스 메서드에 동기화(synchronized) 처리를 하여
 * 여러 스레드가 동시에 객체의 상태를 변경하는 것을 방지하는 예제입니다.
 */
public class Answer3 {
    public static void main(String[] args) throws Exception {
        // 공유 객체인 BankAccount 인스턴스를 하나 생성합니다.
        BankAccount acc = new BankAccount();
        
        // 10번 반복하면서 한 번에 100씩 출금(withdraw)하는 작업을 정의합니다.
        Runnable r = () -> {
            for (int i = 0; i < 10; i++) acc.withdraw(100);
        };
        
        // 두 개의 스레드가 같은 BankAccount 객체를 공유하여 출금을 시도합니다.
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        
        // 두 스레드가 모두 작업을 마칠 때까지 대기합니다.
        t1.join();
        t2.join();
        
        // 동기화가 잘 되어 있으므로 두 스레드가 1000씩, 총 2000을 출금하여 최종 잔액은 0이 됩니다.
        System.out.println("최종 잔액: " + acc.getBalance());
    }
}

/**
 * 은행 계좌를 표현하는 클래스로, 동기화된 메서드를 포함합니다.
 */
class BankAccount {
    // 초기 잔액을 2000으로 설정합니다.
    private int balance = 2000;

    // synchronized 키워드를 통해 여러 스레드가 동시에 이 객체의 withdraw 메서드를 호출할 수 없도록 합니다.
    public synchronized void withdraw(int amt) {
        balance -= amt;
    }

    // 잔액을 확인하는 메서드입니다.
    public int getBalance() {
        return balance;
    }
}
