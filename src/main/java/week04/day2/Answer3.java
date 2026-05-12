package week04.day2;

public class Answer3 {
    public static void main(String[] args) {
        System.out.println("합계 1: " + sum(1, 2, 3));
        System.out.println("합계 2: " + sum(10, 20, 30, 40, 50));
    }

    public static int sum(int... nums) {
        int total = 0;
        for (int n : nums) total += n;
        return total;
    }
}
