package week03.day3;

public class Answer3 {
    public static void main(String[] args) {
        int[][] nums = {
                {5, 12, 8},
                {4, 25, 17},
                {30, 2, 9}
        };
        int max = nums[0][0];
        int row = 0, col = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] > max) {
                    max = nums[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        System.out.printf("최대값: %d, 위치: (%d, %d)\n", max, row, col);
    }
}
