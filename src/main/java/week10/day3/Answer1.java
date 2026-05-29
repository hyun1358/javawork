package week10.day3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 스레드 풀(Thread Pool)을 생성하고 여러 작업을 병렬로 처리하는 예제입니다.
 */
public class Answer1 {
    public static void main(String[] args) {
        // 크기가 3인 고정 스레드 풀을 생성합니다.
        // 최대 3개의 스레드가 동시에 작업을 처리합니다.
        ExecutorService pool = Executors.newFixedThreadPool(3);
        
        // 5개의 작업을 스레드 풀에 제출합니다.
        for (int i = 1; i <= 5; i++) {
            final int id = i;
            // execute() 메서드를 사용하여 반환값이 없는 작업을 스레드 풀에 요청합니다.
            pool.execute(() -> System.out.println("작업 " + id + " " + Thread.currentThread().getName()));
        }
        
        // 더 이상 새로운 작업을 받지 않고, 이미 제출된 작업이 모두 끝나면 스레드 풀을 종료합니다.
        pool.shutdown();
    }
}
