package week10.day1;

/**
 * [실습 1] Thread 클래스 상속을 통한 멀티스레드 생성 (Problem 1 연계)
 * 
 * 자바에서 스레드를 만드는 첫 번째 방법으로, Thread 클래스를 직접 상속(extends Thread)받아 
 * run() 메서드를 오버라이딩하여 독자적인 일꾼을 정의합니다.
 */
public class Example1 {
    static class NumberThread extends Thread {
        @Override
        public void run() {
            System.out.print("[NumberThread 시작] ");
            for (int i = 1; i <= 5; i++) {
                System.out.print(i + " ");
                try { 
                    Thread.sleep(100); // 0.1초 정지
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("[NumberThread 종료]");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== [실습 1] Thread 클래스 상속 예제 ===");
        NumberThread t = new NumberThread();
        
        // 중요: run()이 아닌 start()를 호출해야 새로운 일꾼 스택이 생성됩니다.
        t.start(); 
        
        try { 
            t.join(); // 메인이 끝날 때까지 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
