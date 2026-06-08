package week04.day1;

/**
 * [학습 예제 2] Week 04 Day 1 — 메서드 정의와 호출
 * 
 * [학습 핵심 이론: 코드 재사용의 기본 - 메서드]
 * 2. 매개변수(Parameter)와 전달인자(Argument):
 *    - 매개변수는 메서드를 정의할 때 들어올 데이터 타입을 명시한 변수입니다.
 *    - 전달인자는 메서드를 실제로 호출할 때 전달하는 물리적인 실질 데이터 값입니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: 매개변수와 반환값(return) (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        // Problem 2: 두 정수를 매개변수로 받아 그 합을 반환하는 add 메서드 호출
        int sum = add(15, 25);
        System.out.println("15 + 25 = " + sum);
    }

    static int add(int a, int b) {
        return a + b; // 두 수의 합을 계산하여 반환
    }
}
