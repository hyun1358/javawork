package week04.day3;

/**
 * [학습 예제 5] Week 04 Day 3 — 오버로딩(Overloading)의 상세 규칙
 * 
 * [문제별 학습 목표]
 * - Lab5: 다양한 매개변수를 가진 도형의 넓이 계산기 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        // Problem 5: 원, 사각형, 삼각형 넓이 계산기 (매개변수 시그니처 구별 설계)
        System.out.println("원 넓이(반지름 5.0): " + area(5.0));
        System.out.println("사각형 넓이(10 x 20): " + area(10, 20));
        System.out.println("삼각형 넓이(밑변 10.0 x 높이 5.0): " + area(10.0, 5.0));
    }

    // 원의 넓이
    static double area(double r) {
        return Math.PI * r * r;
    }

    // 사각형의 넓이
    static int area(int w, int h) {
        return w * h;
    }

    // 삼각형의 넓이
    static double area(double base, double height) {
        return base * height / 2.0;
    }
}
