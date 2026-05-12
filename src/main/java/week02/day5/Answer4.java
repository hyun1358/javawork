package week02.day5;

public class Answer4 {
    public static void main(String[] args) {
        outer:
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (i * j > 100) {
                    System.out.println("탈출! " + i + " * " + j + " = " + (i * j));
                    break outer;
                }
            }
        }
    }
}
