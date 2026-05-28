package week04.day4;

/**
 * [예습 파일] Week 04 Day 4 — 재귀 메서드 (Recursion)
 * 
 * [핵심 개념: 나를 다시 부르는 메서드]
 * 1. 재귀 메서드 (Recursive Method):
 *    - 메서드 구현부 내부에서 자기 자신을 다시 호출하여 작업을 반복하는 구조의 함수입니다.
 *    - 수학적 점화식(팩토리얼, 피보나치 등)을 매우 직관적인 코드로 작성할 수 있습니다.
 * 
 * 2. 필수 구성 요소 2가지:
 *    - 기저 조건 (Base Case): 반복을 멈추고 결과값을 즉시 반환하여 호출 스택을 되돌리는 안전 탈출 조건입니다. (이게 없으면 프로그램이 다운됩니다!)
 *    - 재귀 단계 (Recursive Case): 문제를 더 작은 하위 문제로 쪼개어 스스로를 다시 호출하는 구간입니다.
 * 
 * 3. StackOverflowError의 위험성:
 *    - 메서드가 호출될 때마다 JVM의 Stack 영역에 프레임이 계속 쌓います. 재귀 횟수가 너무 깊거나 무한 루프에 빠지면 물리 메모리가 꽉 차며 강제로 셧다운됩니다.
 */
public class Preview {
    public static void main(String[] args) {
        System.out.println("5 팩토리얼: " + factorial(5));
        System.out.println("1~10 합: " + sum(10));
    }

    // 자기 자신을 다시 호출하는 메서드
    public static int factorial(int n) {
        if (n <= 1) return 1; // 탈출 조건 (Base Case)
        return n * factorial(n - 1); // 재귀 호출
    }

    public static int sum(int n) {
        if (n == 1) return 1;
        return n + sum(n - 1);
    }
}
