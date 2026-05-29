package week10.day2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * java.util.concurrent.atomic 패키지의 Atomic 클래스를 사용하여
 * 락(Lock) 없이 원자적 연산(Atomic Operation)으로 스레드 안전성을 보장하는 예제입니다.
 */
public class Answer5 {
    // AtomicInteger를 사용하여 동기화 처리 없이 안전하게 카운트를 증가시킬 수 있습니다.
    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        // Runnable 객체에서 1000번 반복하면서 원자적으로 값을 1 증가시킵니다.
        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) count.incrementAndGet();
        };
        
        // 두 개의 스레드를 생성하고 시작합니다.
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        
        // 스레드 작업 완료 대기
        t1.join();
        t2.join();
        
        // AtomicInteger의 incrementAndGet()는 원자성이 보장되므로 2000이 안전하게 출력됩니다.
        System.out.println("Atomic 카운트 (2000 보장): " + count.get());
    }
}
