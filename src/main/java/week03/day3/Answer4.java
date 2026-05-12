package week03.day3;

public class Answer4 {
    public static void main(String[] args) {
        int[][] scores = {{80, 90, 100}, {70, 60, 50}};
        for (int i = 0; i < scores.length; i++) {
            int sum = 0;
            for (int score : scores[i]) sum += score;
            System.out.printf("%d번 학생 - 합계: %d, 평균: %.1f\n", i + 1, sum, sum / 3.0);
        }
    }
}
