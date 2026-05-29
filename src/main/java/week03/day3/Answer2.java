package week03.day3;

public class Answer2 {
    // 메인 메서드: 2차원 배열의 주 대각선 요소 합계 구하기
    public static void main(String[] args) {
        // 3x3 크기의 2차원 배열 초기화 (미리 값을 할당)
        int[][] matrix = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };
        // 대각선 요소들의 합을 누적할 변수를 0으로 초기화
        int sum = 0;

        // 행렬의 길이(행의 수)만큼 반복
        for (int i = 0; i < matrix.length; i++) {
            // 주 대각선 요소는 행의 인덱스와 열의 인덱스가 같은 요소(matrix[i][i])
            // 해당 요소를 sum에 누적하여 더함
            sum += matrix[i][i];
        }

        // 계산된 대각선 요소의 합계 출력
        System.out.println("대각선 합: " + sum);
    }
}
