package week10.day1;

public class Answer3 {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("현재 스레드: " + Thread.currentThread().getName());
        new Thread(r, "Thread-A").start();
        new Thread(r, "Thread-B").start();
        new Thread(r, "Thread-C").start();
    }
}
