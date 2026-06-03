package week10.day3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * [연습 문제 1] FixedThreadPool 생성
 * 문제: 스레드 3개짜리 풀을 만들고 5개의 출력 작업을 execute()로 던져보세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for(int i = 0; i < 5; i++)
        {
            int finalI = i+1;
            pool.execute(()->{
                System.out.println("실행 "+ finalI+" 쓰레드이름: " + Thread.currentThread().getName());
            });
        }

        pool.shutdown();
    }
}
