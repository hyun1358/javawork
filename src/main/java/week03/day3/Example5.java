package week03.day3;

/**
 * [학습 예제 5] Week 03 Day 3 — 2차원 배열과 격자 데이터
 * 
 * [학습 핵심 이론: 2차원 배열과 격자 데이터 제어]
 * 4. 전치 행렬(Transpose Matrix) 변환 원리:
 *    - 원본 행렬의 `(i, j)` 위치 값을 전치 행렬의 `(j, i)` 위치로 교차 대입하여 행과 열을 바꿉니다.
 * 
 * [문제별 학습 목표]
 * - Lab5: 전치 행렬 (Transpose) 구현 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab5: 전치 행렬 (Transpose) 구현 (Problem 5 연계) ---");
        Lab5.run();
    }

    static class Lab5 {
        static void run() {
            // Problem 5: 3행 2열 행렬 -> 2행 3열 행렬로 전치(Transpose)
            int[][] origin = {
                {1, 2},
                {3, 4},
                {5, 6}
            };
            
            // 전치 행렬의 크기는 원본의 행과 열 크기를 뒤집어서 생성
            int rows = origin.length;       // 3
            int cols = origin[0].length;    // 2
            int[][] transposed = new int[cols][rows]; // 2x3 크기

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    transposed[j][i] = origin[i][j]; // 행과 열 교차 대입
                }
            }

            // 결과 출력
            System.out.println("[원본 3x2 행렬]");
            printMatrix(origin);

            System.out.println("\n[전치된 2x3 행렬]");
            printMatrix(transposed);
        }

        private static void printMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
