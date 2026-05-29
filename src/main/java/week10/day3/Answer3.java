package week10.day3;

import java.util.concurrent.*;

/**
 * ScheduledExecutorService를 사용하여 주기적으로 작업을 실행하는 예제입니다.
 */
public class Answer3 {
    public static void main(String[] args) throws Exception {
        // 스레드가 1개인 스케줄러 스레드 풀을 생성합니다.
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        
        // 초기 지연 시간 0초 후, 1초(TimeUnit.SECONDS) 간격으로 지속적으로 작업을 실행합니다.
        pool.scheduleAtFixedRate(() -> System.out.println("1초마다 실행"), 0, 1, TimeUnit.SECONDS);
        
        // 메인 스레드를 3.5초 동안 대기시켜 스케줄링된 작업이 3~4번 실행될 수 있도록 합니다.
        Thread.sleep(3500); 
        
        // 대기 후, 스레드 풀을 종료하여 스케줄링 작업을 멈추고 프로그램을 종료합니다.
        pool.shutdown();
    }
}
