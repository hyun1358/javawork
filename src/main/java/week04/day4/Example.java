package week04.day4;

import java.util.Arrays;

/**
 * [학습 예제] Week 04 Day 4 — 재귀 호출(Recursion)의 원리와 활용 (카운트다운, 문자열 역순, 거듭제곱, 배열 합, N까지 합)
 * 
 * [학습 핵심 이론: 재귀 설계의 핵심 원칙]
 * 1. Base Case (탈출 조건):
 *    - 재귀 호출을 중단하고 상위 호출로 복귀할 수 있는 조건이 반드시 명시되어야 합니다.
 *    - 탈출 조건이 없거나 부적절하면 호출 스택이 무한히 쌓여 `StackOverflowError` 예외가 발생합니다.
 * 
 * 2. Recursive Step (재귀 단계):
 *    - 문제를 동일한 형태의 더 작은 하위 문제로 분할하여 자신을 재귀적으로 호출하는 단계입니다.
 *    - 예: `N`의 팩토리얼은 `N * (N-1)의 팩토리얼`로 쪼갤 수 있습니다.
 * 
 * 3. 호출 스택 (Call Stack) 동작 방식:
 *    - 재귀가 실행되면 Stack에 새로운 메서드 프레임이 계속 쌓이다가, Base Case에 도달하면 역순으로 계산(후입선출)되며 스택 프레임이 해제됩니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 04 Day 4 학습 예제 ===\n");

        System.out.println("--- Lab1: 재귀적 카운트다운 (10부터 1까지) (Problem 1 연계) ---");
        countDown(10);

        System.out.println("\n--- Lab2: 재귀적 문자열 역순 뒤집기 (Problem 2 연계) ---");
        String original = "Hello";
        String reversed = reverse(original);
        System.out.println("원본 문자열: " + original);
        System.out.println("뒤집힌 결과: " + reversed);

        System.out.println("\n--- Lab3: 재귀적 거듭제곱 계산 (2의 10제곱) (Problem 3 연계) ---");
        int base = 2, exp = 10;
        int powerResult = power(base, exp);
        System.out.println(base + "의 " + exp + "제곱: " + powerResult);

        System.out.println("\n--- Lab4: 재귀를 이용한 배열 요소 합계 구하기 (Problem 4 연계) ---");
        int[] arr = {1, 2, 3, 4, 5};
        int arraySum = sum(arr, arr.length - 1);
        System.out.println("배열 " + Arrays.toString(arr) + "의 요소 합계: " + arraySum);

        System.out.println("\n--- Lab5: 1부터 N까지의 자연수 합계 구하기 (Problem 5 연계) ---");
        int n = 10;
        int sumToResult = sumTo(n);
        System.out.println("1부터 " + n + "까지의 합계: " + sumToResult);

        System.out.println("\n--- Lab6: 피보나치 수열과 스택 오버플로우 개념 ---");
        Lab6.run();
    }

    // Problem 1: 10부터 1까지 거꾸로 출력하는 재귀 메서드
    public static void countDown(int n) {
        // Base Case (탈출 조건)
        if (n < 1) {
            return;
        }
        System.out.print(n + " ");
        // Recursive Step
        countDown(n - 1);
    }

    // Problem 2: 재귀적 문자열 뒤집기
    public static String reverse(String s) {
        // Base Case (더 이상 뒤집을 문자가 없으면 빈 문자열 반환)
        if (s.isEmpty()) {
            return s;
        }
        // 첫 글자를 떼어 맨 뒤로 보내고, 나머지 문자열을 다시 재귀적으로 뒤집어 결합
        return reverse(s.substring(1)) + s.charAt(0);
    }

    // Problem 3: 거듭제곱 계산 (base^exp)
    public static int power(int base, int exp) {
        // Base Case: 어떤 수의 0제곱은 항상 1
        if (exp == 0) {
            return 1;
        }
        // a^b = a * a^(b-1)
        return base * power(base, exp - 1);
    }

    // Problem 4: 재귀적 배열 원소 합계 구하기
    // index는 배열의 마지막 요소 위치부터 0번째 요소 위치까지 줄여나갑니다.
    public static int sum(int[] arr, int index) {
        // Base Case: 인덱스가 0일 때 첫 번째 방의 값을 반환하며 종료
        if (index == 0) {
            return arr[0];
        }
        // 현재 인덱스의 값 + (0부터 index-1까지의 누적합)
        return arr[index] + sum(arr, index - 1);
    }

    // Problem 5: n부터 1까지 합계 구하기
    public static int sumTo(int n) {
        // Base Case: 1까지 도달하면 1 반환
        if (n == 1) {
            return 1;
        }
        // N + (N-1까지의 합)
        return n + sumTo(n - 1);
    }

    static class Lab6 {
        static void run() {
            // 피보나치 수열 시뮬레이션
            System.out.print("피보나치 수열(1~10번째 항): ");
            for (int i = 1; i <= 10; i++) {
                System.out.print(fibonacci(i) + " ");
            }
            System.out.println();
        }

        static int fibonacci(int n) {
            if (n <= 2) return 1;
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
