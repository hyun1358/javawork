package week10.day2;

/**
 * volatile 키워드를 사용하여 멀티스레드 환경에서
 * 변수 값의 가시성(Visibility) 문제를 해결하는 예제입니다.
 */
public class Answer4 {
    // volatile을 선언하면 각 스레드가 캐시 메모리가 아닌 메인 메모리에서 직접 값을 읽고 쓰게 됩니다.
    static volatile boolean running = true;

    public static void main(String[] args) throws Exception {
        // 새로운 스레드를 생성하여 running이 true인 동안 무한 루프를 돌게 합니다.
        new Thread(() -> {
            while (running) {
                // running이 false가 되기를 기다림
            }
            // 루프를 탈출하면 스레드가 종료됨을 출력합니다.
            System.out.println("스레드 종료됨");
        }).start();

        // 메인 스레드는 0.1초 동안 대기합니다.
        Thread.sleep(100); 
        
        // running 값을 false로 변경합니다.
        // volatile 덕분에 변경된 값이 즉시 다른 스레드에게 보이게 되어 무한 루프를 빠져나올 수 있습니다.
        running = false; 
        System.out.println("메인 종료 설정");
    }
}
