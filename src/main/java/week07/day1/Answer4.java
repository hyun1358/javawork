package week07.day1;

/**
 * 객체가 null일 때 메서드나 필드에 접근하면 발생하는 예외(NullPointerException)를 처리하는 예제입니다.
 */
public class Answer4 {
    public static void main(String[] args) {
        try {
            // 문자열 변수 str을 null로 초기화합니다.
            String str = null;
            // 실제 객체가 없는 상태에서 length() 메서드를 호출하려고 하여 예외가 발생합니다.
            str.length();
        } catch (NullPointerException e) {
            // Null 참조 오류 발생 시 이를 잡아내어 메시지를 출력합니다.
            System.out.println("값이 null입니다.");
        }
    }
}
