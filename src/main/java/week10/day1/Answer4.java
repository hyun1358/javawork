package week10.day1;

// 스레드의 대기 상태 제어(join)를 보여주는 예제입니다.
public class Answer4 {
    public static void main(String[] args) {
        // 새로운 스레드 t1을 생성합니다.
        Thread t1 = new Thread(() -> {
            try {
                // 스레드를 1초(1000 밀리초) 동안 일시 정지시킵니다.
                Thread.sleep(1000);
            } catch (Exception e) {
                // InterruptedException 예외 처리가 필요합니다.
            }
            // 일시 정지 후 작업 완료 메시지를 출력합니다.
            System.out.println("t1 작업 완료");
        });
        // 스레드 t1을 실행합니다.
        t1.start();
        
        try {
            // 메인 스레드는 t1 스레드의 실행이 완전히 끝날 때까지 대기합니다.
            t1.join(); // t1이 끝날 때까지 대기
        } catch (InterruptedException e) {
            // join() 호출 시 발생할 수 있는 예외를 처리합니다.
        }
        // t1 스레드가 종료된 후 메인 스레드의 마지막 작업을 수행합니다.
        System.out.println("메인 종료");
    }
}
