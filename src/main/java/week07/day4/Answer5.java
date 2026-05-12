package week07.day4;

public class Answer5 {
    public static void main(String[] args) {
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            System.out.println("getMessage: " + e.getMessage());
            System.out.println("toString: " + e.toString());
            System.out.println("printStackTrace: ");
            e.printStackTrace();
        }
    }
}
