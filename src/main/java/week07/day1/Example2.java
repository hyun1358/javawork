package week07.day1;

/**
 * [학습 예제 2] Week 07 Day 1 — 예외 처리(Exception Handling) 기초
 * 
 * [학습 핵심 이론: 자바 예외 처리 메커니즘]
 * 2. try-catch 구조:
 *    - `try { ... }`: 예외가 발생할 위험이 있는 감시 코드를 작성합니다.
 *    - `catch (ExceptionType e) { ... }`: try 내에서 해당 예외가 터지면 제어권이 넘어와 에러 복구/안내를 처리합니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: ArrayIndexOutOfBoundsException (배열 인덱스 초과) 처리 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab2: ArrayIndexOutOfBoundsException (배열 인덱스 초과) 처리 (Problem 2 연계) ---");
        Lab2.run();
    }

    static class Lab2 {
        static void run() {
            try {
                // Problem 2: 크기가 2인 배열에 3번째 값(인덱스 2) 대입 시도
                int[] arr = new int[2];
                arr[2] = 100;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("예외 처리 완료: 유효하지 않은 배열 인덱스 접근입니다! (" + e.getMessage() + ")");
            }
        }
    }
}
