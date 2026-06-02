package week10.day2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * [실습 5] AtomicInteger 객체를 이용한 고속 락 프리 원자 연산 (Problem 5 연계)
 * 
 * 비유: "줄 서지 않고 누르는 마술 버튼"
 * synchronized는 대기 줄을 세워 다른 스레드를 멈추게 하지만,
 * AtomicInteger는 락을 걸지 않는 락 프리(Lock-free, CAS) 기법을 사용하여
 * 하드웨어 수준에서 안전하고 초고속으로 값을 증가시킬 수 있게 합니다.
 */
public class Example5 {
    public static void main(String[] args) throws Exception {
        System.out.println("=== [실습 5] AtomicInteger 객체를 이용한 고속 락 프리 원자 연산 ===");
        AtomicInteger atomicCount = new AtomicInteger(0);
        
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                atomicCount.incrementAndGet(); // 하드웨어 수준에서 단번에 안전하게 1 증가 연산 수행
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();

        System.out.println("기대 수치: 2000");
        System.out.println("AtomicInteger 결과: " + atomicCount.get());
        System.out.println("-> 설명: 줄 서서 기다리는 대기 시간 없이, CAS 원리에 의해 안전하게 2000을 연산했습니다.");
    }
}
