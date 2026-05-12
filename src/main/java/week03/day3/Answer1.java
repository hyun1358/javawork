package week03.day3;

/* 정답 파일 Answer1 ~ Answer5 통합 */
public class Answer1 {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        int val = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = val++;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
// (Answer2~5 내용은 생략하고 파일로 생성)
