package week11.day5;

/**
 * [연습 문제 1] 클래스 정보 출력
 * 문제: String.class를 통해 String 클래스가 가진 필드 개수와 메서드 개수를 출력하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        Class<?> strClass = String.class;
        System.out.println("클래스명: " + strClass.getName());
        System.out.println("선언된 필드 수: " + strClass.getDeclaredFields().length);
        System.out.println("선언된 메서드 수: " + strClass.getDeclaredMethods().length);

    }
}
