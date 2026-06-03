package week10.day3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * [실습 5] shutdown()의 목적 정리 (Problem 5 연계)
 * 
 * 비유: "퇴근 시간에 회사 문 닫기"
 * 스레드 풀을 만들어 사용한 후 shutdown()을 호출해 문을 닫지 않으면, 
 * 백그라운드 워커 일꾼들이 계속 생존해서 대기실을 지키고 있기 때문에 JVM 프로세스가 영원히 종료되지 않습니다.
 * shutdown()은 기존에 하던 잔여 업무들을 모두 정상 처리한 후, 새로운 일감을 거부하며 안전하게 퇴근합니다.
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("=== [실습 5] shutdown()의 당위성 예제 ===");
        
        ExecutorService pool = Executors.newFixedThreadPool(2);
        
        pool.execute(() -> {
            System.out.println("마지막 작업 실행 중 → " + Thread.currentThread().getName());
        });

        // 만약 아래 shutdown() 줄을 주석 처리하면:
        //  -> 프로그램이 종료되지 않고 빨간색 정지 버튼이 계속 활성화된 채 멈춰 있습니다.
        // shutdown()을 호출하면:
        //  -> 이미 들어온 일만 책임지고 끝내고, 인력 풀을 닫아 프로그램이 무사히 자동 정지합니다.
        pool.shutdown();
        
        System.out.println("스레드 풀 pool shutdown 예약 완료!");
    }
}
