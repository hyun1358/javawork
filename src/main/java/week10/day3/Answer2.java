package week10.day3;

import java.util.concurrent.*;

/**
 * Callable을 사용하여 작업의 결과를 Future 객체로 반환받는 예제입니다.
 */
public class Answer2 {
    public static void main(String[] args) throws Exception {
        // 단일 스레드로 동작하는 스레드 풀을 생성합니다.
        ExecutorService pool = Executors.newSingleThreadExecutor();
        
        // submit() 메서드를 사용하여 결과를 반환하는 작업을 제출합니다.
        // 작업이 완료될 때까지의 결과를 Future 객체로 받습니다.
        Future<String> future = pool.submit(() -> "작업 완료");
        
        // get() 메서드는 작업이 완료될 때까지 블로킹(대기)하다가 결과를 반환합니다.
        System.out.println(future.get());
        
        // 스레드 풀 종료
        pool.shutdown();
    }
}
