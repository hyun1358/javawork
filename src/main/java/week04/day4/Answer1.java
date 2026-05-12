package week04.day4;

public class Answer1 {
    public static void main(String[] args) {
        countDown(10);
    }

    public static void countDown(int n) {
        if (n < 1) return;
        System.out.print(n + " ");
        countDown(n - 1);
    }
}
