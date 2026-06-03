package week10.day1;

/**
 * [실습 2] Runnable 인터페이스 구현을 통한 멀티스레드 생성 (Problem 2 연계)
 * 
 * 자바에서 스레드를 만드는 두 번째 방법으로, Runnable 인터페이스를 구현(implements Runnable)합니다.
 * 자바는 단일 상속만 허용하므로, 다른 클래스를 확장해야 하는 유연한 설계를 위해 실무에서 강력 추천하는 방식입니다.
 */
public class Example2 {
    static class NumberRunnable implements Runnable {
        @Override
        public void run() {
            System.out.print("[NumberRunnable 시작] ");
            for (int i = 1; i <= 5; i++) {
                System.out.print(i + " ");
                try { 
                    Thread.sleep(100); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("[NumberRunnable 종료]");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== [실습 2] Runnable 인터페이스 구현 예제 ===");
        
        // Runnable 구현체를 만들어 Thread 생성자 인자로 넘겨줍니다.
        Thread t = new Thread(new NumberRunnable());
        t.start();
        
        try { 
            t.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
