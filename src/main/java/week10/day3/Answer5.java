package week10.day3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 스레드 풀을 사용한 후 shutdown() 호출의 중요성을 보여주는 예제입니다.
 */
public class Answer5 {
    public static void main(String[] args) {
        // 단일 스레드로 동작하는 스레드 풀을 생성합니다.
        ExecutorService pool = Executors.newSingleThreadExecutor();
        
        // 간단한 출력 작업을 스레드 풀에 제출합니다.
        pool.execute(() -> System.out.println("작업"));
        
        // 더 이상 작업이 없음을 알리고 스레드 풀을 정상적으로 종료시킵니다.
        pool.shutdown();
        
        /*
         * shutdown()을 호출하지 않으면 스레드 풀 내부의 유휴 스레드(Idle Thread)가 계속 살아있어
         * 메인 스레드(main 메서드)가 끝나도 JVM이 애플리케이션을 완전히 종료하지 못하고 대기 상태에 빠지게 됩니다.
         */
    }
}
