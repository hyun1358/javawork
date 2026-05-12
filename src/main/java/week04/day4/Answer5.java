package week04.day4;

public class Answer5 {
    public static void main(String[] args) {
        System.out.println(sumTo(10));
    }

    public static int sumTo(int n) {
        if (n == 1) return 1;
        return n + sumTo(n - 1);
    }
}
