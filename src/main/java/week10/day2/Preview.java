package week10.day2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * [예습 파일] Week 10 Day 2 — 스레드 동기화 (Synchronization)
 * 
 * [핵심 개념: 멀티스레드 안전과 모니터 락]
 * 1. 동시성 문제 (Concurrency Issue)와 임계 영역 (Critical Section):
 *    - 여러 스레드가 메모리 내의 동일한 공유 자원(변수, 객체)에 동시에 쓰기(Write) 작업을 수행할 때 데이터가 꼬여서 논리 오류가 터지는 영역을 '임계 영역'이라 합니다.
 * 
 * 2. synchronized 키워드의 구원:
 *    - 특정 메서드나 코드 블록에 `synchronized`를 선언하면, 단 하나의 스레드만 해당 자원의 '모니터 락(Monitor Lock)'을 획득해 진입할 수 있도록 열쇠를 잠급니다.
 *    - 먼저 열쇠를 쥔 스레드가 작업을 마치고 락을 반환하기 전까지는, 다른 대기 스레드들은 절대 들어가지 못하고 Blocking 상태로 안전하게 대기하게 됩니다.
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
