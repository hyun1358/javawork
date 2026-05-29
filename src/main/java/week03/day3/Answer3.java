package week03.day3;

public class Answer3 {
    // 메인 메서드: 2차원 배열에서 최댓값과 그 위치(행, 열)를 찾는 로직 실행
    public static void main(String[] args) {
        // 3x3 크기의 2차원 배열 초기화
        int[][] nums = {
                {5, 12, 8},
                {4, 25, 17},
                {30, 2, 9}
        };
        // 최댓값을 배열의 첫 번째 요소로 초기 가정
        int max = nums[0][0];
        // 최댓값의 행(row)과 열(col) 인덱스를 저장할 변수를 0으로 초기화
        int row = 0, col = 0;

        // 바깥쪽 반복문: 배열의 행을 순회
        for (int i = 0; i < nums.length; i++) {
            // 안쪽 반복문: 각 행에 속한 열을 순회
            for (int j = 0; j < nums[i].length; j++) {
                // 현재 순회 중인 요소가 저장된 max 값보다 큰지 확인
                if (nums[i][j] > max) {
                    // 더 큰 값을 발견하면 최댓값 갱신
                    max = nums[i][j];
                    // 해당 최댓값이 위치한 행(i)과 열(j) 인덱스를 기록
                    row = i;
                    col = j;
                }
            }
        }
        // 찾은 최댓값과 그 위치를 서식 문자열(printf)을 사용하여 출력
        System.out.printf("최대값: %d, 위치: (%d, %d)\n", max, row, col);
    }
}
