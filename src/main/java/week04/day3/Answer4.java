package week04.day3;

public class Answer4 {
    public static void main(String[] args) {
        System.out.println(getType(10));
        System.out.println(getType(1.23));
        System.out.println(getType("Hello"));
    }

    public static String getType(int v) {
        return "정수";
    }

    public static String getType(double v) {
        return "실수";
    }

    public static String getType(String v) {
        return "문자열";
    }
}
