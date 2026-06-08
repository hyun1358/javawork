package week04.day4;

/**
 * [학습 예제 3] Week 04 Day 4 — 재귀 호출(Recursion)의 원리와 활용
 * 
 * [학습 핵심 이론: 재귀 설계의 핵심 원칙]
 * 2. Recursive Step (재귀 단계):
 *    - 예: `N`의 팩토리얼은 `N * (N-1)의 팩토리얼`로 쪼글 수 있습니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: 재귀적 거듭제곱 계산 (2의 10제곱) (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        int base = 2, exp = 10;
        int powerResult = power(base, exp);
        System.out.println(base + "의 " + exp + "제곱: " + powerResult);
    }

    public static int power(int base, int exp) {
        // Base Case: 어떤 수의 0제곱은 항상 1
        if (exp == 0) {
            return 1;
        }
        // a^b = a * a^(b-1)
        return base * power(base, exp - 1);
    }
}
