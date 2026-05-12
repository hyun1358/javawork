package week10.day1;

public class Answer5 {
    public static void main(String[] args) {
        Thread count = new Thread(() -> {
            for (int i = 5; i >= 1; i--) {
                System.out.println("카운트: " + i);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        });
        count.start();
    }
}
