package week11.day5;

// 리플렉션(Reflection)을 사용하여 클래스의 메타데이터(필드, 메서드 수)를 조회하는 예제입니다.
public class Answer1 {
    // 메인 메서드
    public static void main(String[] args) {
        // String 클래스의 메타 정보를 담고 있는 Class 객체를 가져옵니다.
        Class<?> strClass = String.class;
        // getDeclaredFields()를 통해 클래스에 선언된 모든 필드(변수)의 개수를 출력합니다.
        System.out.println("필드 수: " + strClass.getDeclaredFields().length);
        // getDeclaredMethods()를 통해 클래스에 선언된 모든 메서드의 개수를 출력합니다.
        System.out.println("메서드 수: " + strClass.getDeclaredMethods().length);
    }
}
