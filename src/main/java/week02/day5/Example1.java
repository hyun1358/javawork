package week02.day5;

/**
 * [학습 예제 1] Week 02 Day 5 — break와 continue 활용
 * 
 * [학습 핵심 이론: 반복 제어 실무 패턴]
 * [문제별 학습 목표]
 * - Lab1: 별 패턴 만들기 (중첩 for)
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: 별 패턴 만들기 (중첩 for) ---");
        Lab1.run();
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
}
