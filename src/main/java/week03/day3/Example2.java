package week03.day3;

/**
 * [학습 예제 2] Week 03 Day 3 — 2차원 배열과 격자 데이터
 * 
 * [학습 핵심 이론: 2차원 배열과 격자 데이터 제어]
 * 3. 대각선 요소 접근:
 *    - 정사각형(N x N) 행렬의 대각선 요소는 행 번호와 열 번호가 같습니다 (`matrix[i][i]`).
 * 
 * [문제별 학습 목표]
 * - Lab2: 행렬의 대각선 원소 합 구하기 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab2: 행렬의 대각선 원소 합 구하기 (Problem 2 연계) ---");
        Lab2.run();
    }

    static class Lab2 {
        static void run() {
            // Problem 2: 주 대각선(Diagonal) 요소의 합 구하기
            int[][] matrix = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
            };
            int sum = 0;
            for (int i = 0; i < matrix.length; i++) {
                // 대각선 요소는 행과 열 인덱스가 동일함
                sum += matrix[i][i];
            }
            System.out.println("주 대각선 요소들의 합: " + sum);
        }
    }
}
