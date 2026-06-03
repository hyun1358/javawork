package week10.day3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * [실습 2] Callable + Future (Problem 2 연계)
 * 
 * 비유: "진동벨(Future)과 심부름꾼(Callable)"
 * Runnable은 시킨 일을 하고 끝내지만(결과 반환 불가), Callable은 심부름 결과를 손에 쥐어 돌려줍니다.
 * 작업을 제출(submit)하면 즉시 진동벨(Future)을 받고, 작업이 끝나면 진동벨을 울려 결과(.get())를 가져옵니다.
 */
public class Example2 {
    public static void main(String[] args) throws Exception {
        System.out.println("=== [실습 2] Callable + Future 예제 ===");
        ExecutorService pool = Executors.newSingleThreadExecutor();

        // Callable<String>: 최종 연산 결과로 String을 반환하는 작업 정의
        Callable<String> task = () -> {
            Thread.sleep(200); // 0.2초 걸리는 업무 시뮬레이션
            return "심부름 물건 배달 완료!";
        };

        // 작업을 제출하고 결과물을 챙겨올 진동벨(Future)을 즉시 받아옵니다.
        Future<String> future = pool.submit(task);

        System.out.println("매장에서 결과를 기다리는 중...");
        
        // .get()을 호출하면 작업이 완전히 끝날 때까지 멈춰서 기다린 뒤(블로킹) 결과물을 꺼냅니다.
        String result = future.get(); 
        
        System.out.println("Future로 꺼낸 실제 결과: " + result);
        
        pool.shutdown();
    }
}
