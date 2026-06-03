package week10.day3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * [보충 문제 1_1 정답] 제한된 스레드로 대량의 작업 순차 처리하기
 */
public class Answer1_1 {
    public static void main(String[] args) {
        // 1. 스레드 2개짜리 풀 생성
        ExecutorService pool = Executors.newFixedThreadPool(2);

        // 2. 10개의 작업을 순차 제출
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            pool.execute(() -> {
                System.out.println("작업 " + taskId + " 처리 중 - 스레드 이름: " + Thread.currentThread().getName());
            });
        }

        // 3. 스레드 풀 안전 종료
        pool.shutdown();
    }
}
