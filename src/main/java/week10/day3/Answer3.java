package week10.day3;

import java.util.concurrent.*;

public class Answer3 {
    public static void main(String[] args) throws Exception {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        pool.scheduleAtFixedRate(() -> System.out.println("1초마다 실행"), 0, 1, TimeUnit.SECONDS);
        Thread.sleep(3500); // 3.5초 후
        pool.shutdown(); // 프로그램 종료
    }
}
