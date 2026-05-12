package week10.day1;

public class Answer4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            System.out.println("t1 작업 완료");
        });
        t1.start();
        try {
            t1.join(); // t1이 끝날 때까지 대기
        } catch (InterruptedException e) {
        }
        System.out.println("메인 종료");
    }
}
