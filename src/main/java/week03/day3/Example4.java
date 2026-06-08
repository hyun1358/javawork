package week03.day3;

/**
 * [학습 예제 4] Week 03 Day 3 — 2차원 배열과 격자 데이터
 * 
 * [문제별 학습 목표]
 * - Lab4: 성적표 합계 및 평균 표 포맷 출력 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab4: 성적표 합계 및 평균 표 포맷 출력 (Problem 4 연계) ---");
        Lab4.run();
    }

    static class Lab4 {
        static void run() {
            // Problem 4: 성적표 학생별 합계 및 평균 계산 표 형태 출력
            int[][] scores = {
                {80, 90, 100}, // 1번 학생 국어, 영어, 수학
                {70, 60, 50}   // 2번 학생 국어, 영어, 수학
            };

            System.out.println("학생번호\t총점\t평균");
            System.out.println("========================");
            for (int i = 0; i < scores.length; i++) {
                int sum = 0;
                for (int j = 0; j < scores[i].length; j++) {
                    sum += scores[i][j];
                }
                double avg = (double) sum / scores[i].length;
                System.out.printf("%d\t%d\t%.2f\n", (i + 1), sum, avg);
            }
        }
    }
}
