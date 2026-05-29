package week03.day3;

public class Answer5 {
    // 메인 메서드: 2차원 행렬을 전치(Transpose, 행과 열을 바꿈)하는 로직 실행
    public static void main(String[] args) {
        // 3행 2열 크기의 원본 2차원 배열 생성
        int[][] origin = {{1, 2}, {3, 4}, {5, 6}};
        // 전치 행렬을 저장할 배열을 생성. 원본이 3x2이므로 전치는 2x3 크기.
        int[][] trans = new int[2][3];

        // 원본 배열의 행을 순회
        for (int i = 0; i < origin.length; i++) {
            // 원본 배열의 열을 순회
            for (int j = 0; j < origin[i].length; j++) {
                // 행(i)과 열(j)의 위치를 바꾸어 전치 행렬에 저장
                trans[j][i] = origin[i][j];
            }
        }

        // 생성된 전치 행렬을 출력
        for (int[] row : trans) { // 각 행을 순회
            for (int val : row) { // 행 내의 각 요소를 순회
                System.out.print(val + " "); // 요소를 공백으로 구분하여 출력
            }
            System.out.println(); // 한 행의 출력이 끝나면 줄바꿈
        }
    }
}
