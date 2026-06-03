package week10.day3;

import java.util.concurrent.*;

/**
 * [보충 문제 2_2] 다중 Callable 연산 결과 병렬 취합하기
 * 
 * [문제]
 * 실무에서는 여러 개의 독립적인 연산이나 API 호출을 병렬로 처리한 뒤 합치는 패턴이 매우 자주 쓰입니다.
 * 
 * 3개 이상의 스레드를 가질 수 있는 고정 스레드 풀을 생성하고 아래 연산을 병렬로 처리하세요.
 * 1. 작업 A: 10을 제곱한 값(100)을 반환하는 Callable<Integer>
 * 2. 작업 B: 20을 제곱한 값(400)을 반환하는 Callable<Integer>
 * 3. 작업 C: 30을 제곱한 값(900)을 반환하는 Callable<Integer>
 * 
 * 세 작업을 동시에 submit() 하여 각각의 Future를 얻은 후,
 * 모든 결과를 get() 하여 총합(100 + 400 + 900 = 1400)을 구해 콘솔에 출력하세요.
 * 연산 완료 후 스레드 풀을 안전하게 종료하세요.
 */
public class Problem2_2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // TODO: 3개의 작업을 병렬로 제출하고 결과를 취합하여 총합을 출력하는 코드를 작성하세요.
        ExecutorService pool = Executors.newFixedThreadPool(5);

        Callable[] callArr = new Callable[3];

        Callable<Integer> task1 = () ->
        {
            return 100;
        };
        Callable<Integer> task2 = () ->
        {
            return 400;
        };
        Callable<Integer> task3 = () ->
        {
            return 900;
        };
        callArr[0]=task1;
        callArr[1]=task2;
        callArr[2]=task3;

        Future<Integer>[] future = new Future[3];
        for(int i = 0; i < 3; i++)
        {
            future[i] = pool.submit(callArr[i]);
        }

        int total = 0;

        for(int i = 0; i < 3; i++)
        {
            total+=future[i].get();
        }

        System.out.println(total);
        pool.shutdown();
    }
}
