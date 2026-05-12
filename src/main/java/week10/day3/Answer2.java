package week10.day3;

import java.util.concurrent.*;

public class Answer2 {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Future<String> future = pool.submit(() -> "작업 완료");
        System.out.println(future.get());
        pool.shutdown();
    }
}
