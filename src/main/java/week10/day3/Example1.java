package week10.day3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * [실습 1] FixedThreadPool + execute() (Problem 1 연계)
 * 
 * 비유: "고정 멤버를 둔 소규모 팀(Thread Pool)"
 * 매번 손님이 들어올 때마다 새 직원을 뽑는(new Thread) 대신, 3명의 고정 직원(FixedThreadPool(3))을
 * 대기실에 미리 준비해 두고 5개의 작업을 나누어 처리하도록 지시합니다.
 */
public class Example1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== [실습 1] FixedThreadPool + execute() 예제 ===");
        
        // 스레드 3개짜리 인력사무소(풀) 생성
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            final int num = i;
            pool.execute(() -> {
                System.out.println("작업 " + num + " 실행 → " + Thread.currentThread().getName());
            });
        }
        
        // 중요: 반드시 shutdown 해야 일꾼 대기실이 닫히고 JVM(프로그램)이 완전히 종료됩니다.
        pool.shutdown();
        
        // awaitTermination: 최대 3초간 풀이 완전히 종료될 때까지 대기
        pool.awaitTermination(3, TimeUnit.SECONDS);
    }
}
