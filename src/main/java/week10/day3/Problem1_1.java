package week10.day3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * [보충 문제 1_1] 제한된 스레드로 대량의 작업 순차 처리하기
 * 
 * [문제]
 * 2개의 스레드만 갖는 고정 스레드 풀(FixedThreadPool)을 생성하세요.
 * 그리고 1부터 10까지의 숫자를 출력하는 10개의 작업을 execute()로 던져보세요.
 * 출력 형식: "작업 {숫지} 처리 중 - 스레드 이름: {현재스레드명}"
 * 모든 작업 제출 후 풀을 정상 종료(shutdown) 하세요.
 */
public class Problem1_1 {
    public static void main(String[] args)
    {
        // TODO: 2개 스레드 고정 풀 생성 및 10개 작업 순차 처리 구현
        ExecutorService pool = Executors.newFixedThreadPool(2);

        for(int i = 1; i <= 10; i++)
        {
            final int num = i;
            pool.execute(()->
            {
                System.out.println("작업 {"+num+"} 처리중 - 스레드 이름: " + Thread.currentThread().getName());
            });
        }

        pool.shutdown();
    }
}
