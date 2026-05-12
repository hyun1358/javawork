package week10.day2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * [예습 파일] Week 10 Day 2 — 스레드 동기화 (Synchronization)
 */
public class Preview {
    static int sharedCount = 0;
    static AtomicInteger atomicCount = new AtomicInteger(0); // 동기화 보장

    public static void main(String[] args) throws Exception {
        Runnable r = () -> {
            for (int i = 0; i < 10000; i++) {
                increment(); // 일반 동기화
                atomicCount.incrementAndGet(); // 원자적 동기화
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("일반 동기화 카운트: " + sharedCount);
        System.out.println("Atomic 카운트: " + atomicCount.get());
    }

    // synchronized로 한 번에 하나의 스레드만 접근 가능하도록 보호
    synchronized static void increment() {
        sharedCount++;
    }
}
