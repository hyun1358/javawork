package week10.day2;

public class Answer4 {
    static volatile boolean running = true;

    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            while (running) {
            }
            System.out.println("스레드 종료됨");
        }).start();

        Thread.sleep(100); // 0.1초 뒤
        running = false; // volatile 덕분에 즉시 가시성 확보됨
        System.out.println("메인 종료 설정");
    }
}
