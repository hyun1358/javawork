package week04.day3;

/**
 * [학습 예제] Week 04 Day 3 — 오버로딩의 원리
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: 타입별 출력 오버로딩 ===");
        print(100);
        print(3.14);
        print("자바 공부 중");

        System.out.println("\n=== Lab2: 도형 넓이 구하기 (오버로딩) ===");
        System.out.println("원 넓이(반지름 5): " + area(5));
        System.out.println("사각형 넓이(5x10): " + area(5, 10));
    }

    // Lab1 메서드들
    public static void print(int val) {
        System.out.println("정수: " + val);
    }

    public static void print(double val) {
        System.out.println("실수: " + val);
    }

    public static void print(String val) {
        System.out.println("문자열: " + val);
    }

    // Lab2 메서드들
    public static double area(int r) {
        return Math.PI * r * r;
    }

    public static int area(int w, int h) {
        return w * h;
    }
}
