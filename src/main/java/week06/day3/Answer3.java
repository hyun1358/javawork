package week06.day3;

public class Answer3 {
    public static void main(String[] args) {
        // 모든 클래스의 최상위 조상인 Object 타입 변수에 String 객체를 대입합니다. (업캐스팅)
        Object obj = "Hello";
        
        // instanceof 연산자를 사용하여 obj가 참조하는 실제 객체가 String 타입인지 안전하게 확인합니다.
        if (obj instanceof String) {
            // String 타입이 확실하므로, Object를 String으로 강제 형변환(다운캐스팅)합니다.
            String str = (String) obj;
            // 이제 String 클래스에만 존재하는 length() 메서드를 호출할 수 있습니다.
            System.out.println("문자열 길이: " + str.length());
        }
    }
}
