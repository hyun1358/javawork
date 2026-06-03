package week10.day1;

/**
 * [실습 5] sleep()을 이용한 1초 주기 카운트다운 스레드 (Problem 5 연계)
 * 
 * Thread.sleep(밀리초) API를 활용해, 현재 작업 스레드를 정확하게 1초(1000ms) 동안 
 * 일시 정지(Timed Waiting) 상태로 잠재운 뒤 깨우는 형태의 카운트다운을 시뮬레이션합니다.
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("=== [실습 5] sleep() 카운트다운 예제 ===");
        System.out.println("3초 카운트다운을 시작합니다...");
        
        Thread countdown = new Thread(() -> {
            for (int i = 3; i >= 1; i--) {
                System.out.println("카운트다운: " + i);
                try {
                    Thread.sleep(1000); // 1초씩 일시 정지
                } catch (InterruptedException e) {
                    System.out.println("카운트다운 차단됨");
                }
            }
            System.out.println("카운트다운 완료! 발사!");
        });

        countdown.start();
        
        try { 
            countdown.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
