package week04.day5;

public class Answer5 {
    public static void main(String[] args) {
        System.out.println(cleanString("  java  "));
    }

    public static String cleanString(String s) {
        return s.trim().toUpperCase();
    }
}
