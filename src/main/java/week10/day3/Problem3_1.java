package week10.day3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * [보충 문제 3_1] 3초 뒤 1회성 스케줄 작업 실행하기
 * 
 * [문제]
 * ScheduledExecutorService를 사용하여 주기적인 반복이 아니라,
 * 프로그램 실행 후 3초(3000ms) 뒤에 딱 한 번만 "시스템 점검 시작!" 문구를 출력하는 단발성 작업을 예약하세요.
 * (힌트: scheduleAtFixedRate가 아닌 pool.schedule(Runnable, delay, unit) 메서드를 사용합니다.)
 * 예약 후 메인 스레드는 출력을 볼 수 있도록 4초 대기한 다음 스레드 풀을 종료하세요.
 */
public class Problem3_1 {
    public static void main(String[] args) throws InterruptedException
    {
        // TODO: 3초 후 1회성 스케줄링 작업 예약 및 실행 구현
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.schedule(()-> System.out.println("시스템 점검 시작"),3,TimeUnit.SECONDS);
        Thread.sleep(4000);

        scheduler.shutdown();
        //프로그램 시작하면 scheduler.schedule(()-> System.out.println("시스템 점검 시작"),3,TimeUnit.SECONDS); 이게 바로 실행되고 Thread.sleep(4000); 이것고 같이 실행되는건가? 결과적으로 메인은 4초만
        //정지하고 위에코드는 3초뒤 1번만 실행되는 건가?
    }
}
