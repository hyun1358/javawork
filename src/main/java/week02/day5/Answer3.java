package week02.day5;

public class Answer3 {
    public static void main(String[] args) {
        for (int j = 1; j <= 9; j++) {
            for (int i = 2; i <= 9; i++) {
                System.out.printf("%d * %d = %d\t", i, j, i * j);
            }
            System.out.println();
        }
    }
}
