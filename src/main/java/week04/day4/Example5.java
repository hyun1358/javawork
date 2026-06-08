package week04.day4;

/**
 * [학습 예제 5] Week 04 Day 4 — 재귀 호출(Recursion)의 원리와 활용
 * 
 * [문제별 학습 목표]
 * - Lab5: 1부터 N까지의 자연수 합계 구하기 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        int n = 10;
        int sumToResult = sumTo(n);
        System.out.println("1부터 " + n + "까지의 합계: " + sumToResult);
    }

    public static int sumTo(int n) {
        // Base Case: 1까지 도달하면 1 반환
        if (n == 1) {
            return 1;
        }
        // N + (N-1까지의 합)
        return n + sumTo(n - 1);
    }
}
