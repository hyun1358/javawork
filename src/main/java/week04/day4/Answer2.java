package week04.day4;

public class Answer2 {
    public static void main(String[] args) {
        System.out.println(reverse("Hello"));
    }

    public static String reverse(String s) {
        if (s.isEmpty()) return s;
        return reverse(s.substring(1)) + s.charAt(0);
    }
}
