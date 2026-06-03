package week10.day3;

import java.util.concurrent.*;

/**
 * [보충 문제 2_1] Callable과 Future를 활용한 "합계 계산기"
 * 
 * [문제]
 * 단일 스레드 풀을 생성하세요.
 * 1부터 10까지 더한 결과(55)를 계산하여 Integer 타입으로 반환하는 Callable<Integer> 작업을 정의하고 제출하세요.
 * 메인 스레드에서 Future.get()을 사용하여 연산 결과를 받아 화면에 출력해 보세요.
 * 작업이 끝난 후 스레드 풀을 종료하세요.
 */
public class Problem2_1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // TODO: Callable을 통해 1~10의 합을 구해 Future로 출력하는 구조를 완성하세요.
        ExecutorService pool = Executors.newFixedThreadPool(1);

        Callable<Integer> task = () ->
        {
            int num = 0;
            for(int i = 1; i <= 10; i++)
            {
                num+=i;
            }
            return num;
        };
        Future<Integer> future = pool.submit(task);
        int result = future.get();
        System.out.println(result);

        pool.shutdown();
    }
}
