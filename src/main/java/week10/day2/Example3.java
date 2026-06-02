package week10.day2;

/**
 * [실습 3] 임계 영역 동기화가 적용된 은행 계좌 동시 출금 (Problem 3 연계)
 * 
 * 비유: "한 사람씩만 사용할 수 있는 은행 출금 창구"
 * 만약 출금 메서드에 자물쇠(synchronized)가 없다면, 잔액이 부족한 상황에서도
 * 두 스레드가 동시에 잔액 조건을 통과해 계좌에 마이너스가 나는 금융 사고가 터질 수 있습니다.
 * synchronized를 적용해 한 고객의 출금이 완전히 끝나야 다음 고객이 출금하도록 순서를 제어합니다.
 */
public class Example3 {
    static class BankAccount {
        private int balance = 1000; // 초기 잔액 1000원

        // synchronized를 붙여 동시에 돈을 뽑아가지 못하도록 막습니다.
        public synchronized void withdraw(int amount) {
            if (balance >= amount) {
                // 동시성 상황을 유도하기 위해 일부러 아주 잠깐 쉬어줍니다.
                try { 
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " 출금 완료. (남은 잔액: " + balance + "원)");
            } else {
                System.out.println(Thread.currentThread().getName() + " 출금 실패: 잔액 부족! (현재 잔액: " + balance + "원)");
            }
        }

        public int getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("=== [실습 3] 임계 영역 동기화가 적용된 은행 계좌 동시 출금 ===");
        BankAccount account = new BankAccount();
        
        // 100원씩 10번 출금하는 작업 정의 (고객 A, B가 총 20번 시도 -> 잔액은 딱 10번만 허용 가능)
        Runnable withdrawTask = () -> {
            for (int i = 0; i < 10; i++) {
                account.withdraw(100);
            }
        };

        Thread t1 = new Thread(withdrawTask, "고객 A");
        Thread t2 = new Thread(withdrawTask, "고객 B");
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();

        System.out.println("최종 남은 잔액: " + account.getBalance() + "원 (기대 잔액: 0원)");
        System.out.println("-> 설명: 한 번에 한 고객씩 정해진 순서로 100원씩 차감하여 계좌 잔고가 안전하게 0원으로 떨어집니다.");
    }
}
