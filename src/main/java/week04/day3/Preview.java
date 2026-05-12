package week04.day3;

/**
 * [예습 파일] Week 04 Day 3 — 메서드 오버로딩 (Overloading)
 */
public class Preview {
    public static void main(String[] args) {
        // 이름은 같지만 매개변수가 다른 메서드들을 호출합니다.
        System.out.println("정수 합: " + add(10, 20));
        System.out.println("실수 합: " + add(3.14, 2.5));
        System.out.println("세 수 합: " + add(1, 2, 3));
    }

    // 1. 기본 버전
    public static int add(int a, int b) {
        return a + b;
    }

    // 2. 타입이 다른 버전
    public static double add(double a, double b) {
        return a + b;
    }

    // 3. 개수가 다른 버전
    public static int add(int a, int b, int c) {
        return a + b + c;
    }
}
