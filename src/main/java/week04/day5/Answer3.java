package week04.day5;

public class Answer3 {
    public static void main(String[] args) {
        int result = multiply(add(5, 10), 2);
        System.out.println("결과: " + result);
    }

    public static int add(int n, int plus) {
        return n + plus;
    }

    public static int multiply(int n, int mul) {
        return n * mul;
    }
}
