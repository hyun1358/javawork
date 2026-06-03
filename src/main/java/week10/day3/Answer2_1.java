package week10.day3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * [보충 문제 2_1 정답] Callable과 Future를 활용한 "합계 계산기"
 */
public class Answer2_1 {
    public static void main(String[] args) {
        // 1. 단일 스레드 풀 생성
        ExecutorService pool = Executors.newSingleThreadExecutor();

        // 2. 1부터 10까지 더하는 Callable 정의
        Callable<Integer> calculator = () -> {
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += i;
            }
            return sum;
        };

        // 3. 작업 제출 및 Future 획득
        Future<Integer> future = pool.submit(calculator);

        try {
            // 4. 결과값 대기 및 출력
            Integer result = future.get();
            System.out.println("1부터 10까지의 합계 결과: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. 스레드 풀 종료
            pool.shutdown();
        }
    }
}
