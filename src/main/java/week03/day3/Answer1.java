package week03.day3;

/* 정답 파일 Answer1 ~ Answer5 통합 */
public class Answer1 {
    // 메인 메서드: 2차원 배열을 생성하고 값을 할당한 후 출력하는 로직 실행
    public static void main(String[] args) {
        // 3행 3열 크기의 2차원 정수 배열 생성
        int[][] arr = new int[3][3];
        // 배열에 넣을 초기 값 설정 (1부터 시작)
        int val = 1;

        // 바깥쪽 반복문: 배열의 행(row)을 순회 (총 3행)
        for (int i = 0; i < 3; i++) {
            // 안쪽 반복문: 각 행의 열(col)을 순회 (총 3열)
            for (int j = 0; j < 3; j++) {
                // 현재 행과 열의 위치에 val 값을 대입하고, 대입 후 val을 1 증가시킴 (후위 연산자)
                arr[i][j] = val++;
                // 대입된 값을 공백으로 구분하여 한 줄에 출력
                System.out.print(arr[i][j] + " ");
            }
            // 한 행의 출력이 끝나면 줄바꿈 수행
            System.out.println();
        }
    }
}
// (Answer2~5 내용은 생략하고 파일로 생성)
