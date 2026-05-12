package week02.day5;

/**
 * [학습 예제] Week 02 Day 5 — 반복문 심화
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: 별 패턴 만들기 (중첩 for) ===");
        Lab1.run();

        System.out.println("\n=== Lab2: 레이블(Label) break ===");
        Lab2.run();
    }

    static class Lab1 {
        static void run() {
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

    static class Lab2 {
        static void run() {
            outer:
            // 레이블 이름
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    if (i == 2 && j == 2) break outer; // 바깥쪽 루프까지 한 번에 탈출
                    System.out.println("i=" + i + ", j=" + j);
                }
            }
        }
    }
}
