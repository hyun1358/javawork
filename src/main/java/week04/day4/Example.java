package week04.day4;

/**
 * [학습 예제] Week 04 Day 4 — 재귀의 한계와 활용
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: 피보나치 수열 ===");
        for (int i = 1; i <= 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        System.out.println("\n\n=== Lab2: 스택 오버플로우 (주의!) ===");
        // infinite(1); // 이 코드는 에러를 발생시킵니다.
    }

    public static int fibonacci(int n) {
        if (n <= 2) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void infinite(int n) {
        // 탈출 조건이 없으면 StackOverflowError가 발생합니다.
        infinite(n + 1);
    }
}
