package week02.day5;

public class Answer3 {
    public static void main(String[] args) {
        // 구구단을 가로로 출력하기 위한 이중 루프입니다.
        // 줄(행)을 의미하는 j가 1부터 9까지 커지고, 단(열)을 의미하는 i가 안쪽에서 2부터 9까지 반복됩니다.
        for (int j = 1; j <= 9; j++) {
            for (int i = 2; i <= 9; i++) {
                System.out.printf("%d * %d = %d\t", i, j, i * j);
            }
            System.out.println();
        }
    }
}
