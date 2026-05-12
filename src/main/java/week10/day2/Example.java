package week10.day2;

/**
 * [학습 예제] Week 10 Day 2 — 동기화 안 했을 때의 문제점
 */
public class Example {
    static int count = 0;

    public static void main(String[] args) throws Exception {
        System.out.println("=== Lab: 공유 자원 동시 접근 오류 ===");
        Runnable r = () -> {
            for (int i = 0; i < 10000; i++) count++;
            // count++는 읽기, 더하기, 쓰기의 3단계이므로 동시 접근 시 데이터가 유실됨
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("결과 (20000이 아닐 확률이 높음): " + count);
    }
}
