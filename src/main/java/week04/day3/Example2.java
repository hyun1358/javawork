package week04.day3;

/**
 * [학습 예제 2] Week 04 Day 3 — 오버로딩(Overloading)의 상세 규칙
 * 
 * [문제별 학습 목표]
 * - Lab2: multiply 연산 오버로딩 (2개 곱, 3개 곱, 실수 곱) (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        // Problem 2: 정수 2개 곱, 정수 3개 곱, 실수 2개 곱 처리
        System.out.println("5 * 8 = " + multiply(5, 8));
        System.out.println("2 * 3 * 4 = " + multiply(2, 3, 4));
        System.out.println("2.5 * 1.5 = " + multiply(2.5, 1.5));
    }

    static int multiply(int a, int b) {
        return a * b;
    }

    static int multiply(int a, int b, int c) {
        return a * b * c;
    }

    static double multiply(double a, double b) {
        return a * b;
    }
}
