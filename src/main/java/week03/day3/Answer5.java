package week03.day3;

public class Answer5 {
    public static void main(String[] args) {
        int[][] origin = {{1, 2}, {3, 4}, {5, 6}};
        int[][] trans = new int[2][3];
        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < origin[i].length; j++) {
                trans[j][i] = origin[i][j];
            }
        }
        for (int[] row : trans) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }
}
