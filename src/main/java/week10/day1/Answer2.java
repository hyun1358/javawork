package week10.day1;

public class Answer2 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 1; i <= 5; i++) System.out.println("Runnable: " + i);
        });
        t.start();
    }
}
