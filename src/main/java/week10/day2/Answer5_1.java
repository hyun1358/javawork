package week10.day2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * [보충 문제 5_1 정답] AtomicInteger 실무 응용 - 콘서트 예매 카운터
 * 
 * 해설: 10개의 스레드가 동시에 1000번씩 호출하더라도, incrementAndGet()을 통해
 * CPU 수준에서 쪼개지지 않는 원자적 연산을 안전하게 수행하므로
 * 자물쇠(lock) 없이도 정확하게 10,000의 총합이 보장됩니다.
 */
public class Answer5_1 {
    // AtomicInteger로 카운터 선언
    static AtomicInteger bookingCounter = new AtomicInteger(0);
    
    public static void main(String[] args) {
        System.out.println("=== [보충 5_1 정답] 콘서트 실시간 예매 카운터 작동 시작 ===");
        
        Runnable ticketTask = () -> {
            for (int i = 0; i < 1000; i++) {
                // 원자적 증가 메서드 호출
                bookingCounter.incrementAndGet();
            }
        };

        // 10명의 동시 접속 스레드 생성
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(ticketTask);
            threads[i].start();
        }

        // 모든 스레드가 작업을 마칠 때까지 대기
        try {
            for (int i = 0; i < 10; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 최종 안전 수치 검증 및 출력
        System.out.println("기대 수치: 10000 | 실제 최종 예매 수: " + bookingCounter.get());
    }
}
