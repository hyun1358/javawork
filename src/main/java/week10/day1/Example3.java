package week10.day1;

/**
 * [실습 3] 실행 중인 스레드의 이름 식별 (Problem 3 연계)
 * 
 * Thread.currentThread().getName() 메서드를 활용하여
 * 멀티스레드 환경에서 각각의 작업 일꾼이 어떤 이름을 부여받아 수행 중인지 고유 식별 명칭을 출력합니다.
 */
public class Example3 {
    static class NamePrinterRunnable implements Runnable {
        @Override
        public void run() {
            // 현재 작업 스레드의 이름 획득
            String threadName = Thread.currentThread().getName();
            System.out.println("-> 현재 구동 중인 스레드 이름: " + threadName);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== [실습 3] 실행 중인 스레드의 이름 식별 예제 ===");
        
        // 3개의 고유한 이름을 부여한 스레드 생성
        Thread t1 = new Thread(new NamePrinterRunnable(), "스레드-A");
        Thread t2 = new Thread(new NamePrinterRunnable(), "스레드-B");
        Thread t3 = new Thread(new NamePrinterRunnable(), "스레드-C");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
