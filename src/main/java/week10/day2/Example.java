package week10.day2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * [학습 예제] Week 10 Day 2 — 스레드 동기화와 자원 공유 (공유 자원 경쟁 조건, synchronized 메서드, 은행 계좌 출금 동기화, volatile 메모리 가시성, AtomicInteger 락프리 정적 카운터)
 * 
 * [학습 핵심 이론: 멀티스레드 동성 자원 관리와 스레드 안전]
 * 1. 경쟁 조건 (Race Condition):
 *    - 둘 이상의 스레드가 공유 자원에 동시 쓰기 연산을 할 때, 자바의 `count++` 등은 단일 연산(Atomic)이 아닌 [CPU 읽기 -> 연산 -> 쓰기]의 3단계 명령어이므로 실행 중간에 다른 스레드가 침범하여 이전 값을 덮어써 연산 유실이 발생하는 현상입니다. (Problem 1 연계)
 * 
 * 2. synchronized 키워드:
 *    - 자바 객체가 갖는 고유 락(Monitor Lock)을 획득한 하나의 스레드만 임계 영역(Critical Section) 메서드/블록에 진입하도록 제어함으로써 상호 배제(Mutual Exclusion)를 달성합니다. (Problem 2, 3 연계)
 * 
 * 3. volatile 키워드와 메모리 가시성(Visibility):
 *    - 멀티스레드 환경에서 CPU 캐시 메모리가 아닌 항상 메인 메모리(RAM)로부터 변수 값을 읽고 쓰도록 강제하여, 한 스레드가 수정한 공유 변수 플래그가 다른 스레드에게 즉시 반영되도록 보장합니다. (Problem 4 연계)
 * 
 * 4. 원자적 연산 객체 (Atomic Classes):
 *    - 락(Lock)을 걸지 않는 락 프리(Lock-free) 기법(CAS - Compare And Swap 알고리즘)을 하드웨어 수준에서 지원하여 동기화 블록보다 가볍고 빠른 원자적 연산을 보장합니다. (Problem 5 연계)
 */
public class Example {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Week 10 Day 2 학습 예제 ===\n");

        System.out.println("--- Lab1: 스레드 안전하지 않은 공유 변수 경쟁 조건 재현 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: synchronized 메서드를 적용한 스레드 안전 증가 연산 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: 임계 영역 동기화가 적용된 은행 계좌 동시 출금 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: volatile 플래그를 이용한 스레드 간 메모리 가시성 보장 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: AtomicInteger 객체를 이용한 고속 락 프리 원자 연산 (Problem 5 연계) ---");
        Lab5.run();
    }

    // Problem 1, 2, 5용 공통 카운터 클래스
    static class Counter {
        private int count = 0;

        // 비동기화 메소드 (경쟁 조건 발생)
        public void increment() {
            count++;
        }

        // synchronized 동기화 메소드 (Problem 2 연계)
        public synchronized void synchronizedIncrement() {
            count++;
        }

        public int getCount() { return count; }
        public void reset() { count = 0; }
    }

    // Problem 3용 BankAccount 클래스
    static class BankAccount {
        private int balance = 1000; // 초기 잔액 1000원

        // synchronized를 붙여 두 스레드가 동시에 출금 로직에 침범하지 못하게 보호
        public synchronized void withdraw(int amount) {
            if (balance >= amount) {
                try { Thread.sleep(10); } catch (InterruptedException e) {} // 동시성 문제 극대화를 위한 지연
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " 출금 완료. (남은 잔액: " + balance + "원)");
            } else {
                System.out.println(Thread.currentThread().getName() + " 출금 실패: 잔액 부족! (현재 잔액: " + balance + "원)");
            }
        }

        public int getBalance() { return balance; }
    }

    // Problem 4용 Volatile 플래그 클래스
    static class VolatileFlag implements Runnable {
        // volatile이 없으면 CPU 캐시에 저장된 값을 계속 읽어 무한 루프에 빠질 수 있습니다.
        private volatile boolean stopRequested = false;

        public void requestStop() {
            stopRequested = true;
        }

        @Override
        public void run() {
            int count = 0;
            System.out.println("[작업 스레드] 시작합니다.");
            while (!stopRequested) {
                count++; // stopRequested가 true가 될 때까지 무한 루프
            }
            System.out.println("[작업 스레드] 정지 신호 수신 완료. 최종 루프 횟수: " + count);
        }
    }

    static class Lab1 {
        static void run() throws Exception {
            Counter unsafeCounter = new Counter();
            Runnable r = () -> {
                for (int i = 0; i < 1000; i++) {
                    unsafeCounter.increment();
                }
            };

            Thread t1 = new Thread(r);
            Thread t2 = new Thread(r);
            t1.start(); t2.start();
            t1.join(); t2.join();

            System.out.println("기대 수치: 2000 | 실제 비동기화 결과: " + unsafeCounter.getCount());
        }
    }

    static class Lab2 {
        static void run() throws Exception {
            Counter safeCounter = new Counter();
            Runnable r = () -> {
                for (int i = 0; i < 1000; i++) {
                    safeCounter.synchronizedIncrement(); // 동기화 메서드 호출
                }
            };

            Thread t1 = new Thread(r);
            Thread t2 = new Thread(r);
            t1.start(); t2.start();
            t1.join(); t2.join();

            System.out.println("기대 수치: 2000 | synchronized 처리 결과: " + safeCounter.getCount() + " (안전)");
        }
    }

    static class Lab3 {
        static void run() throws Exception {
            BankAccount account = new BankAccount();
            
            // 100원씩 10번 출금하는 작업 정의
            Runnable withdrawTask = () -> {
                for (int i = 0; i < 10; i++) {
                    account.withdraw(100);
                }
            };

            Thread t1 = new Thread(withdrawTask, "고객 A");
            Thread t2 = new Thread(withdrawTask, "고객 B");
            t1.start(); t2.start();
            t1.join(); t2.join();

            System.out.println("최종 남은 잔액: " + account.getBalance() + "원 (기대 잔액: 0원)");
        }
    }

    static class Lab4 {
        static void run() throws Exception {
            VolatileFlag flagTask = new VolatileFlag();
            Thread worker = new Thread(flagTask);
            worker.start();

            Thread.sleep(100); // 메인 스레드 잠시 대기
            System.out.println("[메인 스레드] 작업 정지를 요청합니다.");
            flagTask.requestStop(); // stopRequested 플래그를 true로 변경
            
            worker.join(); // 메인 메모리에 가시성이 보장되어 즉시 종료됨을 확인
            System.out.println("[메인 스레드] 작업 스레드가 무사히 종료되었습니다.");
        }
    }

    static class Lab5 {
        static void run() throws Exception {
            // Problem 5: AtomicInteger 사용
            AtomicInteger atomicCount = new AtomicInteger(0);
            
            Runnable task = () -> {
                for (int i = 0; i < 1000; i++) {
                    atomicCount.incrementAndGet(); // 원자적(Atomic) 1 증가 연산 수행
                }
            };

            Thread t1 = new Thread(task);
            Thread t2 = new Thread(task);
            t1.start(); t2.start();
            t1.join(); t2.join();

            System.out.println("기대 수치: 2000 | AtomicInteger 결과: " + atomicCount.get());
        }
    }
}
