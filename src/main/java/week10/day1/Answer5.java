package week10.day1;

// Thread.sleep()을 활용한 카운트다운 스레드 예제입니다.
public class Answer5 {
    public static void main(String[] args) {
        // 카운트다운을 수행하는 스레드를 생성합니다.
        Thread count = new Thread(() -> {
            // 5부터 1까지 1씩 감소하며 반복합니다.
            for (int i = 5; i >= 1; i--) {
                System.out.println("카운트: " + i);
                try {
                    // 매 출력 후 1초(1000 밀리초)씩 스레드를 대기시킵니다.
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // 스레드 대기 중 발생할 수 있는 예외를 처리합니다.
                }
            }
        });
        // 카운트다운 스레드를 실행합니다.
        count.start();
    }
}
