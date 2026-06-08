package week03.day3;

/**
 * [학습 예제 3] Week 03 Day 3 — 2차원 배열과 격자 데이터
 * 
 * [학습 핵심 이론: 2차원 배열과 격자 데이터 제어]
 * 2. 중첩 for문을 이용한 2차원 배열 탐색:
 *    - 행을 담당하는 바깥 루프와 열을 담당하는 안쪽 루프의 2중 구조로 격자 내 모든 요소를 빠짐없이 탐색(Full Scan)합니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: 2차원 배열 내 최댓값과 그 위치(행, 열) 찾기 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab3: 2차원 배열 내 최댓값과 그 위치(행, 열) 찾기 (Problem 3 연계) ---");
        Lab3.run();
    }

    static class Lab3 {
        static void run() {
            // Problem 3: 2차원 배열에서 최댓값과 그 인덱스 좌표 찾기
            int[][] nums = {
                {5, 12, 8},
                {4, 25, 17},
                {30, 2, 9}
            };
            int max = nums[0][0];
            int maxRow = 0;
            int maxCol = 0;

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] > max) {
                        max = nums[i][j];
                        maxRow = i;
                        maxCol = j;
                    }
                }
            }
            System.out.println("최댓값: " + max);
            System.out.printf("최댓값 위치: 행=%d, 열=%d\n", maxRow, maxCol);
        }
    }
}
