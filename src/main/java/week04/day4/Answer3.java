package week04.day4;

public class Answer3 {
    public static void main(String[] args) {
        System.out.println(power(2, 10));
    }

    public static int power(int base, int exp) {
        if (exp == 0) return 1;
        return base * power(base, exp - 1);
    }
}
