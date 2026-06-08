package week01.day3;

/**
 * [학습 예제 2] Week 01 Day 3 — 연산자 종합
 * 
 * [학습 핵심 이론: 자바의 연산자 체계]
 * 3. 비교/관계 연산자 (Comparison Operators):
 *    - ==, !=, >, <, >=, <=
 *    - 피연산자들의 값을 크기 비교하여 무조건 boolean(true/false) 형태의 결과로 반환합니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: 비교 연산자 (==, !=, >, <, >=, <=)
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("--- Lab2: 비교 연산자 (==, !=, >, <, >=, <=) ---");
        Lab2.run();
        System.out.println("\n[해설] 비교 연산의 결과는 항상 boolean(true/false)입니다.");
    }

    static class Lab2 {
        static void run() {
            int a = 10, b = 20;
            System.out.println("a == b : " + (a == b));
            System.out.println("a != b : " + (a != b));
            System.out.println("a < b  : " + (a < b));
        }
    }
}
