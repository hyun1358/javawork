package week03.day3;

public class Answer2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        System.out.println("대각선 합: " + sum);
    }
}
