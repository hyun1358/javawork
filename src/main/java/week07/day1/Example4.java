package week07.day1;

/**
 * [학습 예제 4] Week 07 Day 1 — 예외 처리(Exception Handling) 기초
 * 
 * [문제별 학습 목표]
 * - Lab4: NullPointerException (참조값 없음 오류) 처리 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab4: NullPointerException (참조값 없음 오류) 처리 (Problem 4 연계) ---");
        Lab4.run();
    }

    static class Lab4 {
        static void run() {
            try {
                // Problem 4: null 객체의 인스턴스 메서드(length()) 호출 시도
                String str = null;
                System.out.println("문자열 길이: " + str.length());
            } catch (NullPointerException e) {
                System.out.println("예외 처리 완료: 가리키는 실제 메모리 객체가 없습니다! (NullPointerException)");
            }
        }
    }
}
