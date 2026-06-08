package week02.day1;

/**
 * [학습 예제 4] Week 02 Day 1 — IF 조건문 기초
 * 
 * [문제별 학습 목표]
 * - Lab4: 중첩 if 문
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("--- Lab4: 중첩 if 문 ---");
        Lab4.run();
        System.out.println("\n[해설] if 문 안에 또 다른 if 문을 넣을 수 있습니다. 상세한 분류가 가능합니다.");
    }

    static class Lab4 {
        static void run() {
            int score = 95;
            if (score >= 90) {
                if (score >= 95) {
                    System.out.println("A+ 학점입니다.");
                } else {
                    System.out.println("A0 학점입니다.");
                }
            }
        }
    }
}
