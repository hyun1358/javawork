package week04.day4;

/**
 * [학습 예제 1] Week 04 Day 4 — 재귀 호출(Recursion)의 원리와 활용
 * 
 * [학습 핵심 이론: 재귀 설계의 핵심 원칙]
 * 1. Base Case (탈출 조건):
 *    - 재귀 호출을 중단하고 상위 호출로 복귀할 수 있는 조건이 반드시 명시되어야 합니다.
 * 
 * 2. Recursive Step (재귀 단계):
 *    - 문제를 동일한 형태의 더 작은 하위 문제로 분할하여 자신을 재귀적으로 호출하는 단계입니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: 재귀적 카운트다운 (10부터 1까지) (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        countDown(10);
    }

    public static void countDown(int n) {
        // Base Case (탈출 조건)
        if (n < 1) {
            return;
        }
        System.out.print(n + " ");
        // Recursive Step
        countDown(n - 1);
    }
}
