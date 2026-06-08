package week01.day2;

/**
 * [학습 예제 5] Week 01 Day 2 — 변수와 기본 자료형 및 데이터 특징
 * 
 * [학습 핵심 이론: 변수 선언과 메모리 자료형]
 * 2. 자바의 기본 자료형:
 *    - 논리형: boolean(1B) - true 또는 false의 값만 가짐.
 * 
 * [문제별 학습 목표]
 * - Lab5: 논리형(boolean)과 문자열(String)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("--- Lab5: 논리형(boolean)과 문자열(String) ---");
        Lab5.run();
        System.out.println("\n[해설] boolean은 true/false만 가지며, String은 문자열을 저장합니다.");
    }

    static class Lab5 {
        static void run() {
            boolean isHappy = true;
            String message = "Hello Java";
            System.out.println("행복여부: " + isHappy);
            System.out.println("메시지: " + message);
        }
    }
}
