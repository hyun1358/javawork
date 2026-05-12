package week07.day1;

public class Answer4 {
    public static void main(String[] args) {
        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("값이 null입니다.");
        }
    }
}
