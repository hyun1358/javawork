package week10.day3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * [학습 예제] Week 10 Day 3 — Callable, Future 및 ArrayBlockingQueue 동시성 제어
 */
public class Example {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newSingleThreadExecutor();

        System.out.println("=== Lab 1: 결과 반환이 있는 Callable ===");
        // Callable은 Runnable과 달리 return 값이 있습니다.
        Callable<Integer> task = () -> {
            Thread.sleep(500);
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

        System.out.println("\n=== Lab 2: ArrayBlockingQueue 활용 (동시성 큐) ===");
        runBlockingQueue();
    }

    public static void runBlockingQueue() throws Exception {
        // 최대 3개까지 수용할 수 있는 BlockingQueue를 생성합니다.
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        
        System.out.println("큐에 데이터 삽입...");
        queue.put("DataA");
        queue.put("DataB");
        
        System.out.println("큐 크기: " + queue.size());
        System.out.println("꺼내온 데이터: " + queue.take());
        System.out.println("꺼내온 데이터: " + queue.take());
    }
}
