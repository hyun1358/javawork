package week10.day3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * [보충 문제 3_1 정답] 3초 뒤 1회성 스케줄 작업 실행하기
 */
public class Answer3_1 {
    public static void main(String[] args) {
        // 1. 스케줄러 스레드 풀 생성
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);

        System.out.println("프로그램을 시작합니다. (3초 뒤 점검 예약)");

        // 2. 3초 뒤 딱 한 번만 실행하는 schedule 메서드 사용
        pool.schedule(
            () -> System.out.println("시스템 점검 시작!"), 
            3, TimeUnit.SECONDS
        );

        try {
            // 3. 작업이 실행되는 것을 보기 위해 4초 대기
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 4. 스레드 풀 종료
            pool.shutdown();
        }
    }
}
