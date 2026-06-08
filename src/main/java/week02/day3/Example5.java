package week02.day3;

/**
 * [학습 예제 5] Week 02 Day 3 — for 반복문 기초
 * 
 * [문제별 학습 목표]
 * - Lab5: 향상된 for-each 문 (맛보기)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("--- Lab5: 향상된 for-each 문 (맛보기) ---");
        Lab5.run();
        System.out.println("\n[해설] 배열이나 컬렉션의 모든 요소를 순차적으로 꺼낼 때 매우 편리합니다.");
    }

    static class Lab5 {
        static void run() {
            int[] scores = {90, 80, 100};
            for (int score : scores) {
                System.out.println("점수: " + score);
            }
        }
    }
}
