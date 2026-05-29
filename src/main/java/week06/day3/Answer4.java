package week06.day3;

public class Answer4 {
    public static void main(String[] args) {
        // Object 타입 변수에 String 문자열 객체를 대입합니다.
        Object obj = "String";
        try {
            // [에러 발생 지점] 실제로는 String 객체인데, 강제로 Integer로 다운캐스팅을 시도합니다.
            // 서로 상속 관계가 아닌 자식 타입으로의 변환이므로 실행 시 ClassCastException 예외가 발생합니다.
            Integer num = (Integer) obj; // ClassCastException 발생
        } catch (ClassCastException e) {
            // 발생한 예외를 안전하게 잡아내고 에러 메시지를 출력합니다.
            System.out.println("다운캐스팅 에러 잡힘: " + e.getMessage());
        }
    }
}
