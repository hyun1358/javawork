package week10.day3;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * [보충 문제 5_1] 스레드 풀의 안전한 종료와 대기 (awaitTermination)
 * 
 * [문제]
 * 단일 스레드 풀(SingleThreadExecutor)을 생성하고, 1초(1000ms) 동안 대기한 후 "작업 완료"를 출력하는 작업을 제출하세요.
 * 작업을 제출한 직후 pool.shutdown()을 호출하여 스레드 풀을 종료 대기 상태로 만드세요.
 * 그 후 pool.awaitTermination(2, TimeUnit.SECONDS)을 사용하여 스레드가 최대 2초간 안전하게 종료되기를 기다린 뒤,
 * 종료가 완료되었다면 "스레드 풀 안전하게 종료됨"을 출력하는 코드를 완성하세요.
 */
public class Problem5_1 {
    public static void main(String[] args) throws InterruptedException {
        // TODO: 단일 스레드 풀을 생성하고 작업을 제출한 후, shutdown() 및 awaitTermination()을 통해 안전하게 대기 및 종료를 구현하세요.

        ExecutorService pool = Executors.newSingleThreadExecutor();

        pool.execute(()->
        {

            try {
                Thread.sleep(1000);
                System.out.println("작업 완료");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        pool.shutdown();

        pool.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("스레드 풀 안전하게 종료됨");
    }
}
