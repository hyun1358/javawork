package week10.day3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * [학습 예제] Week 10 Day 3 — Callable과 Future
 */
public class Example {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();

        System.out.println("=== Lab: 결과 반환이 있는 Callable ===");
        // Callable은 Runnable과 달리 return 값이 있습니다.
        Callable<Integer> task = () -> {
            Thread.sleep(1000);
            return 100 + 200;
        };

        // submit()을 쓰면 결과를 담은 Future 객체를 줍니다.
        Future<Integer> future = pool.submit(task);

        try {
            System.out.println("결과 기다리는 중...");
            int result = future.get(); // 완료될 때까지 블로킹(대기)
            System.out.println("결과: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
}
