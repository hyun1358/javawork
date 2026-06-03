package week10.day1;

/**
 * [실습 4] join()을 이용해 특정 스레드의 완료를 기다리기 (Problem 4 연계)
 * 
 * join() 메서드는 현재 일하고 있는 스레드(여기선 main 스레드)가 대상 스레드(t1)의 작업이 완전히
 * 완료되어 죽을 때까지 대기(Blocked) 상태로 멈추도록 실행 흐름을 제어합니다.
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("=== [실습 4] join() 스레드 제어 흐름 대기 예제 ===");
        
        Thread t1 = new Thread(() -> {
            System.out.println("[t1] 1초간 작업을 수행합니다...");
            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[t1] 1초 작업 완료!");
        });

        t1.start();

        try {
            System.out.println("[main] t1.join() 호출 - t1이 끝날 때까지 대기합니다.");
            t1.join(); // t1이 작업을 완전히 마칠 때까지 메인 스레드가 멈춤
            System.out.println("[main] 대기 해제! t1이 완료되어 메인 스레드가 최종 완료 메시지를 출력합니다.");
        } catch (InterruptedException e) {
            System.out.println("대기 중 예외 발생");
        }
    }
}
