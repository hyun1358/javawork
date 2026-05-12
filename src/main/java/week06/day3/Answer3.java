package week06.day3;

public class Answer3 {
    public static void main(String[] args) {
        Object obj = "Hello";
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println("문자열 길이: " + str.length());
        }
    }
}
