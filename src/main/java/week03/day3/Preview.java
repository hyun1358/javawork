package week03.day3;

/**
 * [예습 파일] Week 03 Day 3 — 2차원 배열 기초
 */
public class Preview {
    public static void main(String[] args) {
        // 1. 2차원 배열 선언 및 초기화 (3행 3열)
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // 2. 이중 for문으로 출력
        System.out.println("--- 3x3 행렬 출력 ---");
        for (int i = 0; i < matrix.length; i++) { // 행 반복
            for (int j = 0; j < matrix[i].length; j++) { // 열 반복
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
