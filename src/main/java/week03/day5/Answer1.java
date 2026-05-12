package week03.day5;

public class Answer1 {
    public static void main(String[] args) {
        int[] lotto = new int[6];
        for (int i = 0; i < 6; i++) {
            lotto[i] = (int) (Math.random() * 45) + 1;
        }
        for (int n : lotto) System.out.print(n + " ");
    }
}
