package week07.day1;

public class Answer1 {
    public static void main(String[] args) {
        try {
            int a = 5 / 0;
        } catch (ArithmeticException e) {
            System.out.println("에러 발생! " + e.getMessage());
        }
    }
}
