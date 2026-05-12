package week07.day3;

public class Answer1 {
    public static void main(String[] args) {
        try {
            validate(-10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void validate(int n) {
        if (n < 0) throw new IllegalArgumentException("음수 불가");
    }
}
