package week07.day1;

/**
 * [학습 예제 3] Week 07 Day 1 — 예외 처리(Exception Handling) 기초
 * 
 * [문제별 학습 목표]
 * - Lab3: NumberFormatException (숫자 파싱 오류) 처리 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab3: NumberFormatException (숫자 파싱 오류) 처리 (Problem 3 연계) ---");
        Lab3.run();
    }

    static class Lab3 {
        static void run() {
            try {
                // Problem 3: 숫자로 파싱이 불가능한 문자열 "ABC" 파싱 시도
                String source = "ABC";
                int number = Integer.parseInt(source);
                System.out.println("변환된 숫자: " + number);
            } catch (NumberFormatException e) {
                System.out.println("예외 처리 완료: 숫자로 변환할 수 없는 문자열 포맷입니다! (" + e.getMessage() + ")");
            }
        }
    }
}
