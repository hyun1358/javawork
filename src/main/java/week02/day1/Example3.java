package week02.day1;

/**
 * [학습 예제 3] Week 02 Day 1 — IF 조건문 기초
 * 
 * [학습 핵심 이론: 분기 처리를 위한 if 제어문]
 * 3. 다중 if-else if-else문:
 *    - 여러 개의 독립된 조건들을 위에서부터 차례로 검사하여 참이 되는 첫 번째 블록만 실행하고 전체 조건문을 탈출.
 * 
 * [문제별 학습 목표]
 * - Lab3: else if 문
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("--- Lab3: else if 문 ---");
        Lab3.run();
        System.out.println("\n[해설] else if를 사용하면 여러 개의 조건을 순차적으로 검사할 수 있습니다.");
    }

    static class Lab3 {
        static void run() {
            int age = 15;
            if (age >= 19) {
                System.out.println("성인");
            } else if (age >= 13) {
                System.out.println("청소년");
            } else {
                System.out.println("어린이");
            }
        }
    }
}
