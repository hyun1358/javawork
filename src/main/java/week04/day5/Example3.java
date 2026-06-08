package week04.day5;

/**
 * [학습 예제 3] Week 04 Day 5 — 메서드 설계와 문서화
 * 
 * [학습 핵심 이론: 클린 코드와 메서드 문서화 표준]
 * 3. 메서드 중첩 호출 (Nesting / Chaining):
 *    - 한 메서드의 반환(return)값을 다른 메서드의 매개변수로 직접 전달하여 임시 변수 선언을 줄이고 직관적인 흐름을 연출합니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: 메서드 중첩 호출 (합산 후 곱하기) (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        int nestedResult = multiply(add(5, 10), 2);
        System.out.println("multiply(add(5, 10), 2) 결과: " + nestedResult);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }
}
