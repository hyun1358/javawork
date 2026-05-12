package week11.day5;

public class Answer1 {
    public static void main(String[] args) {
        Class<?> strClass = String.class;
        System.out.println("필드 수: " + strClass.getDeclaredFields().length);
        System.out.println("메서드 수: " + strClass.getDeclaredMethods().length);
    }
}
