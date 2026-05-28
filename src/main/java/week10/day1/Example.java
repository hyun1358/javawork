package week10.day1;

/**
 * [학습 예제] Week 10 Day 1 — 멀티스레드(Multi-threading) 기초 (Thread 클래스 상속, Runnable 인터페이스 구현, 스레드 이름 조회, join 메서드 동기화, sleep 일시정지)
 * 
 * [학습 핵심 이론: 자바 멀티스레드 기초]
 * 1. 스레드 생성 방식 2가지:
 *    - 방식 1: `Thread` 클래스 상속 (`extends Thread`): `run()` 메서드를 오버라이딩합니다. 자바는 단일 상속만 지원하므로 다른 클래스를 상속받을 수 없는 제약이 생깁니다. (Problem 1 연계)
 *    - 방식 2: `Runnable` 인터페이스 구현 (`implements Runnable`): 인터페이스를 구현한 후 `new Thread(runnable)` 생성자 인자로 넘겨 실행합니다. 상속에 유연하여 실무에서 적극 권장되는 방식입니다. (Problem 2 연계)
 * 
 * 2. 스레드의 주요 제어 API:
 *    - `Thread.currentThread().getName()`: 현재 JVM 상에서 실행 권한을 가진 스레드의 고유 이름을 획득합니다. (Problem 3 연계)
 *    - `Thread.sleep(ms)`: 지정된 밀리초(1/1000초) 시간 동안 현재 스레드를 일시 정지(Timed Waiting) 상태로 전환합니다. `InterruptedException` 처리가 강제됩니다. (Problem 5 연계)
 *    - `t.join()`: 현재 실행 중인 스레드(예: main 스레드)가 대상 스레드 `t`가 완전히 종료될 때까지 대기 상태로 머무르도록 제어 흐름을 동기화합니다. (Problem 4 연계)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 10 Day 1 학습 예제 ===\n");

        System.out.println("--- Lab1: Thread 클래스 상속을 통한 멀티스레드 생성 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: Runnable 인터페이스 구현을 통한 멀티스레드 생성 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: 실행 중인 스레드의 이름 식별 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: join()을 이용해 특정 스레드의 완료를 기다리기 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: sleep()을 이용한 1초 주기 카운트다운 스레드 (Problem 5 연계) ---");
        Lab5.run();
    }

    // Problem 1: Thread 상속 클래스 정의
    static class NumberThread extends Thread {
        @Override
        public void run() {
            System.out.print("[NumberThread 시작] ");
            for (int i = 1; i <= 5; i++) {
                System.out.print(i + " ");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
            System.out.println("[NumberThread 종료]");
        }
    }

    // Problem 2: Runnable 구현 클래스 정의
    static class NumberRunnable implements Runnable {
        @Override
        public void run() {
            System.out.print("[NumberRunnable 시작] ");
            for (int i = 1; i <= 5; i++) {
                System.out.print(i + " ");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
            System.out.println("[NumberRunnable 종료]");
        }
    }

    // Problem 3: 스레드 이름 출력 스레드 정의
    static class NamePrinterRunnable implements Runnable {
        @Override
        public void run() {
            // 현재 작업 스레드의 이름 획득
            String threadName = Thread.currentThread().getName();
            System.out.println("-> 현재 구동 중인 스레드 이름: " + threadName);
        }
    }

    static class Lab1 {
        static void run() {
            NumberThread t = new NumberThread();
            t.start(); // 중요: run()을 직접 호출하지 않고 start()를 호출해야 새로운 호출스택(Call Stack)이 만들어집니다.
            try { t.join(); } catch (InterruptedException e) {} // 순차 출력을 위한 join 대기
        }
    }

    static class Lab2 {
        static void run() {
            Thread t = new Thread(new NumberRunnable());
            t.start();
            try { t.join(); } catch (InterruptedException e) {} // 순차 출력을 위한 join 대기
        }
    }

    static class Lab3 {
        static void run() {
            // 3개의 다른 이름을 가진 스레드 생성
            Thread t1 = new Thread(new NamePrinterRunnable(), "스레드-A");
            Thread t2 = new Thread(new NamePrinterRunnable(), "스레드-B");
            Thread t3 = new Thread(new NamePrinterRunnable(), "스레드-C");

            t1.start();
            t2.start();
            t3.start();

            try {
                t1.join();
                t2.join();
                t3.join();
            } catch (InterruptedException e) {}
        }
    }

    static class Lab4 {
        static void run() {
            // Problem 4: t1 스레드가 1초간 쉬었다가 출력하도록 하고 main에서 대기
            Thread t1 = new Thread(() -> {
                System.out.println("[t1] 1초간 작업을 수행합니다...");
                try {
                    Thread.sleep(1000); // 1초 대기
                } catch (InterruptedException e) {}
                System.out.println("[t1] 1초 작업 완료!");
            });

            t1.start();

            try {
                System.out.println("[main] t1.join() 호출 - t1이 끝날 때까지 대기합니다.");
                t1.join(); // t1이 죽을 때까지 메인 스레드가 멈춤
                System.out.println("[main] 대기 해제! t1이 완료되어 메인 스레드가 최종 완료 메시지를 출력합니다.");
            } catch (InterruptedException e) {
                System.out.println("대기 중 예외 발생");
            }
        }
    }

    static class Lab5 {
        static void run() {
            // Problem 5: 카운트다운 스레드
            System.out.println("3초 카운트다운을 시작합니다...");
            Thread countdown = new Thread(() -> {
                for (int i = 3; i >= 1; i--) {
                    System.out.println("카운트다운: " + i);
                    try {
                        Thread.sleep(1000); // 정확히 1초(1000ms)씩 일시 정지
                    } catch (InterruptedException e) {
                        System.out.println("카운트다운 차단됨");
                    }
                }
                System.out.println("카운트다운 완료! 발사!");
            });

            countdown.start();
            try { countdown.join(); } catch (InterruptedException e) {}
        }
    }
}
