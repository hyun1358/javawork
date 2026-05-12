package week10.day3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * [예습 파일] Week 10 Day 3 — 스레드 풀 (ExecutorService)
 */
public class Preview {
    public static void main(String[] args) {
        // 스레드 2개만 생성해서 풀에 넣어둠
        ExecutorService pool = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            pool.execute(() -> {
                System.out.println("작업 " + taskId + " 실행 중: " + Thread.currentThread().getName());
            });
        }

        pool.shutdown(); // 작업 끝나면 풀 종료 예약
    }
}
