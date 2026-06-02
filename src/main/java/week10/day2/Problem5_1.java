package week10.day2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * [보충 문제 5_1] AtomicInteger 실무 응용 - 콘서트 예매 카운터
 * 
 * 문제: 콘서트 예매가 시작되어 10개의 스레드(동시 접속 손님)가 동시에 예매 버튼을 누릅니다.
 * 각 스레드는 1000번씩 티켓 예매를 시도합니다.
 * synchronized 자물쇠를 전혀 사용하지 말고, 자바 내장 클래스인 AtomicInteger를 사용하여
 * 10개의 스레드가 충돌 없이 안전하게 총 10,000개의 예매 건수를 세어내도록 코드를 완성해 보세요.
 */
public class Problem5_1 {
    // TODO: AtomicInteger를 사용해 예매 카운터를 선언하세요.
    
    public static void main(String[] args) {
        System.out.println("=== [보충 5_1] 콘서트 실시간 예매 카운터 작동 시작 ===");

        AtomicInteger num = new AtomicInteger(0);

        Runnable ticketTask = () -> {
            for (int i = 0; i < 1000; i++) {
                // TODO: 예매 카운트를 원자적으로 1 증가시키세요.
                num.incrementAndGet();
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

        // TODO: 최종 카운트를 출력하여 10000이 보장되는지 확인하세요.
        System.out.println("기대 수치: 10000 | 실제 최종 예매 수: " + num.get());
    }
}
