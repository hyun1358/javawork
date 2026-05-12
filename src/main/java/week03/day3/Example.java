package week03.day3;

/**
 * [학습 예제] Week 03 Day 3 — 2차원 배열 활용
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: 행/열 합계 구하기 ===");
        Lab1.run();

        System.out.println("\n=== Lab2: 가변 배열 (Ragged Array) ===");
        Lab2.run();
    }

    static class Lab1 {
        static void run() {
            int[][] scores = {
                    {90, 80, 70}, // 1번 학생
                    {85, 95, 88}  // 2번 학생
            };
            for (int i = 0; i < scores.length; i++) {
                int sum = 0;
                for (int j = 0; j < scores[i].length; j++) {
                    sum += scores[i][j];
                }
                System.out.printf("%d번 학생 총점: %d\n", i + 1, sum);
            }
        }
    }

    static class Lab2 {
        static void run() {
            int[][] ragged = new int[3][];
            ragged[0] = new int[2];
            ragged[1] = new int[4];
            ragged[2] = new int[3];
            System.out.println("0행 길이: " + ragged[0].length);
            System.out.println("1행 길이: " + ragged[1].length);
            System.out.println("2행 길이: " + ragged[2].length);
        }
    }
}
