package week10.day3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Answer1 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 5; i++) {
            final int id = i;
            pool.execute(() -> System.out.println("작업 " + id + " " + Thread.currentThread().getName()));
        }
        pool.shutdown();
    }
}
