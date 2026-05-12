package week07.day2;

public class Answer5 {
    public static void main(String[] args) {
        try {
            try {
                int a = 1 / 0;
            } catch (ArithmeticException e) {
                System.out.println("내부 catch: " + e.getMessage());
            }
            int[] arr = new int[2];
            arr[3] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("외부 catch: " + e.getMessage());
        }
    }
}
