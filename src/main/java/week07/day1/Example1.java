package week07.day1;

/**
 * [학습 예제 1] Week 07 Day 1 — 예외 처리(Exception Handling) 기초
 * 
 * [학습 핵심 이론: 자바 예외 처리 메커니즘]
 * 1. 예외(Exception)와 에러(Error):
 *    - 에러(Error)는 메모리 부족(OOM) 등 프로그램이 복구할 수 없는 치명적 상황이며, 예외(Exception)는 개발자가 `try-catch`로 포착하여 정상 흐름으로 복구할 수 있는 경미한 결함입니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: ArithmeticException (0 나누기 오류) 처리 (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: ArithmeticException (0 나누기 오류) 처리 (Problem 1 연계) ---");
        Lab1.run();
    }

    static class Lab1 {
        static void run() {
            try {
                // Problem 1: 5를 0으로 나누어 고의로 ArithmeticException 유발
                int result = 5 / 0;
                System.out.println("나눗셈 결과: " + result);
            } catch (ArithmeticException e) {
                System.out.println("예외 처리 완료: 0으로 숫자를 나눌 수 없습니다! (" + e.getMessage() + ")");
            }
        }
    }
}
