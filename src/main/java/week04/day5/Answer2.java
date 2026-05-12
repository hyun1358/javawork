package week04.day5;

public class Answer2 {
    public static void main(String[] args) {
        System.out.println(isValidLogin("java", "12345678"));
    }

    public static boolean isValidLogin(String id, String pw) {
        return id.length() >= 4 && pw.length() >= 8;
    }
}
