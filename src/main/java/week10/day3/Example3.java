package week10.day3;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * [실습 3] ScheduledExecutorService (Problem 3 연계)
 * 
 * 비유: "알람 시계 스케줄러"
 * 특정 시간 뒤에 일을 시작하거나, 일정한 주기마다 반복해서 알람을 울리며(scheduleAtFixedRate)
 * 주기적인 백그라운드 스케줄 작업을 돌릴 때 사용합니다.
 */
public class Example3 {
    public static void main(String[] args) throws Exception {
        System.out.println("=== [실습 3] ScheduledExecutorService 주기 반복 실행 예제 ===");
        
        // 예약 및 주기 실행 전용의 1명짜리 스케줄러 풀 생성
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // 0초 지연 후 시작, 이후 1초 간격으로 반복하여 현재 시각을 출력하도록 지시
        ScheduledFuture<?> scheduledFuture = scheduler.scheduleAtFixedRate(
            () -> System.out.println("현재 시각: " + LocalTime.now()),
            0, 1, TimeUnit.SECONDS
        );

        // 메인 스레드가 3.1초 대기하며 반복 실행을 데모로 관찰합니다.
        Thread.sleep(3100);
        
        // 3초 뒤에 예약을 취소하고 스케줄러를 정지시킵니다.
        scheduledFuture.cancel(false); 
        scheduler.shutdown();
        System.out.println("스케줄러 반복 예약이 취소되고 종료되었습니다.");
    }
}
