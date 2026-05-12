package week04.day3;

public class Answer2 {
    public static void main(String[] args) {
        System.out.println(multiply(2, 3));
        System.out.println(multiply(2, 3, 4));
        System.out.println(multiply(1.5, 2.0));
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int multiply(int a, int b, int c) {
        return a * b * c;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }
}
