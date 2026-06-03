package week10.day3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * [보충 문제 2_2 정답] 다중 Callable 연산 결과 병렬 취합하기
 */
public class Answer2_2 {
    public static void main(String[] args) {
        // 1. 병렬 처리를 위해 스레드 3개짜리 풀 생성
        ExecutorService pool = Executors.newFixedThreadPool(3);

        // 2. 3개의 제곱 연산 작업 정의
        Callable<Integer> taskA = () -> 10 * 10;
        Callable<Integer> taskB = () -> 20 * 20;
        Callable<Integer> taskC = () -> 30 * 30;

        // 3. 비동기/병렬 제출 (제출하는 즉시 진동벨 3개 획득)
        Future<Integer> futureA = pool.submit(taskA);
        Future<Integer> futureB = pool.submit(taskB);
        Future<Integer> futureC = pool.submit(taskC);

        try {
            // 4. 각각의 진동벨에서 결과를 꺼내옴 (세 작업이 동시에 돌아갔으므로 빠름)
            int resultA = futureA.get();
            int resultB = futureB.get();
            int resultC = futureC.get();

            // 5. 총합 계산 및 출력
            int totalSum = resultA + resultB + resultC;
            System.out.println("세 작업의 병렬 연산 총합: " + totalSum); // 1400

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. 스레드 풀 종료
            pool.shutdown();
        }
    }
}
