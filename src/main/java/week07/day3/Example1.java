package week07.day3;

/**
 * [학습 예제 1] Week 07 Day 3 — 예외 발생과 전파
 * 
 * [학습 핵심 이론: 예외의 발생, 전파, 그리고 연결]
 * 1. 예외의 능동적 발생 (`throw` 키워드):
 *    - 프로그램 조건에 맞지 않는 상황(예: 음수 입력)을 감지하면 `throw new ExceptionClass("메시지")` 문장으로 강제 에러를 발생시켜 비정상 처리를 통제할 수 있습니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: IllegalArgumentException 강제 발생 및 캐치 (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: IllegalArgumentException 강제 발생 및 캐치 (Problem 1 연계) ---");
        Lab1.run();
    }

    static class Lab1 {
        static void run() {
            // Problem 1: 음수 입력 시 예외를 던지는 시뮬레이션
            int input = -10;
            try {
                System.out.println("입력값 검증 시도: " + input);
                if (input < 0) {
                    throw new IllegalArgumentException("음수 입력 불가 (전달 값: " + input + ")");
                }
                System.out.println("정상값 통과");
            } catch (IllegalArgumentException e) {
                System.out.println("예외 감지 성공! 사유: " + e.getMessage());
            }
        }
    }
}
