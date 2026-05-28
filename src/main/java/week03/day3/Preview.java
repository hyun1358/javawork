package week03.day3;

/**
 * [예습 파일] Week 03 Day 3 — 배열 복사와 정렬
 * 
 * [핵심 개념: 배열의 고도화 작업]
 * 1. 얕은 복사 (Shallow Copy):
 *    - 배열의 주소값만 복사하여 두 변수가 동일한 실제 힙(Heap) 배열을 가리키게 합니다.
 *    - 한 쪽 변수를 통해 데이터를 수정하면 다른 쪽 변수의 데이터도 같이 변경됩니다.
 * 
 * 2. 깊은 복사 (Deep Copy):
 *    - 완전히 새로운 배열 공간을 힙에 할당하고 기존 데이터를 하나하나 물리적으로 복사합니다.
 *    - 복사 방법: `Arrays.copyOf()`, `System.arraycopy()`, 혹은 루프 직접 대입.
 * 
 * 3. 배열 정렬 (Sort):
 *    - `Arrays.sort()` 메서드는 듀얼 피벗 퀵소트(Dual-Pivot Quicksort) 알고리즘을 사용하여 매우 빠르고 효율적으로 오름차순 정렬을 수행합니다.
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
