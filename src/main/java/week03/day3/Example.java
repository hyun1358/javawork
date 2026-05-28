package week03.day3;

/**
 * [학습 예제] Week 03 Day 3 — 2차원 배열과 격자 데이터 (대각선 합, 최댓값 좌표, 전치 행렬)
 * 
 * [학습 핵심 이론: 2차원 배열과 격자 데이터 제어]
 * 1. 2차원 배열의 구조:
 *    - 2차원 배열은 사실 '배열의 배열'입니다. `matrix.length`는 행의 개수를, `matrix[i].length`는 i번째 행의 열 개수를 뜻합니다.
 *    - 힙(Heap) 메모리상에는 각 행을 가리키는 참조 배열이 먼저 존재하고, 그 참조들이 각 행의 1차원 배열을 다시 가리키는 2단계 링크 구조를 이룹니다.
 * 
 * 2. 중첩 for문을 이용한 2차원 배열 탐색:
 *    - 행을 담당하는 바깥 루프와 열을 담당하는 안쪽 루프의 2중 구조로 격자 내 모든 요소를 빠짐없이 탐색(Full Scan)합니다.
 * 
 * 3. 대각선 요소 접근:
 *    - 정사각형(N x N) 행렬의 대각선 요소는 행 번호와 열 번호가 같습니다 (`matrix[i][i]`).
 * 
 * 4. 전치 행렬(Transpose Matrix) 변환 원리:
 *    - 원본 행렬의 `(i, j)` 위치 값을 전치 행렬의 `(j, i)` 위치로 교차 대입하여 행과 열을 바꿉니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 03 Day 3 학습 예제 ===\n");

        System.out.println("--- Lab1: 2차원 배열 선언, 초기화 및 출력 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: 행렬의 대각선 원소 합 구하기 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: 2차원 배열 내 최댓값과 그 위치(행, 열) 찾기 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: 성적표 합계 및 평균 표 포맷 출력 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: 전치 행렬 (Transpose) 구현 (Problem 5 연계) ---");
        Lab5.run();

        System.out.println("\n--- Lab6: 가변 배열 (Ragged Array)의 이해 ---");
        Lab6.run();
    }

    static class Lab1 {
        static void run() {
            // Problem 1: 3x3 2차원 배열 선언 및 값 대입 후 출력
            int[][] arr = new int[3][3];
            int num = 1;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = num++;
                }
            }

            // 출력 확인
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + "\t");
                }
                System.out.println();
            }
        }
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

    static class Lab6 {
        static void run() {
            // 가변 배열 (각 행마다 열의 크기를 다르게 다차원 배열을 구성)
            int[][] ragged = new int[3][];
            ragged[0] = new int[2];
            ragged[1] = new int[4];
            ragged[2] = new int[3];
            
            System.out.println("0번째 행 열 크기: " + ragged[0].length);
            System.out.println("1번째 행 열 크기: " + ragged[1].length);
            System.out.println("2번째 행 열 크기: " + ragged[2].length);
        }
    }
}
