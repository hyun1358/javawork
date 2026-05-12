package week04.day4;

/**
 * [예습 파일] Week 04 Day 4 — 재귀 메서드 (Recursion)
 */
public class Preview {
    public static void main(String[] args) {
        System.out.println("5 팩토리얼: " + factorial(5));
        System.out.println("1~10 합: " + sum(10));
    }

    // 자기 자신을 다시 호출하는 메서드
    public static int factorial(int n) {
        if (n <= 1) return 1; // 탈출 조건 (Base Case)
        return n * factorial(n - 1); // 재귀 호출
    }

    public static int sum(int n) {
        if (n == 1) return 1;
        return n + sum(n - 1);
    }
}
