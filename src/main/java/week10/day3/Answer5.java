package week10.day3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Answer5 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.execute(() -> System.out.println("작업"));
        pool.shutdown();
        /*
         * shutdown()을 하지 않으면 스레드 풀이 유휴 스레드를 살려두어
         * 메인 프로그램(JVM)이 영원히 종료되지 않습니다.
         */
    }
}
