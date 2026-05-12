package week03.day5;

public class Answer2 {
    public static void main(String[] args) {
        int[] dice = new int[10];
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            dice[i] = (int) (Math.random() * 6) + 1;
            sum += dice[i];
        }
        System.out.println("주사위 합: " + sum);
    }
}
