package week10.day1;

/**
 * [학습 예제] Week 10 Day 1 — 멀티스레드의 동시성 확인
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab: 스레드 동시 실행 ===");
        Thread a = new Thread(() -> printNumbers("A"));
        Thread b = new Thread(() -> printNumbers("B"));

        a.start();
        b.start();
        // A와 B가 섞여서 출력되는 것을 확인할 수 있습니다.
    }

    public static void printNumbers(String name) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            } // 0.1초 쉬기
        }
    }
}
