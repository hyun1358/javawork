package week10.day3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * [보충 문제 5_1 정답] 스레드 풀의 안전한 종료와 대기 (awaitTermination)
 */
public class Answer5_1 {
    public static void main(String[] args) {
        // 1. 단일 스레드 풀 생성
        ExecutorService pool = Executors.newSingleThreadExecutor();

        // 2. 1초 대기 후 출력하는 작업 제출
        pool.execute(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("작업 완료");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 3. 스레드 풀 종료 요청 (새 작업 접수 중단, 기존 작업은 진행)
        pool.shutdown();

        try {
            // 4. 최대 2초 동안 기존 작업이 끝나고 스레드 풀이 완전히 종료되기를 대기
            if (pool.awaitTermination(2, TimeUnit.SECONDS)) {
                System.out.println("스레드 풀 안전하게 종료됨");
            } else {
                System.out.println("대기 시간 내에 스레드 풀이 종료되지 못했습니다.");
            }
        } catch (InterruptedException e) {
            System.err.println("대기 중 인터럽트 발생");
            pool.shutdownNow(); // 강제 종료
        }
    }
}
