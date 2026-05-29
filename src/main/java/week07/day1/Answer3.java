package week07.day1;

/**
 * 문자열을 숫자로 변환할 때 발생하는 예외(NumberFormatException)를 처리하는 예제입니다.
 */
public class Answer3 {
    public static void main(String[] args) {
        try {
            // 숫자가 아닌 문자열 "ABC"를 정수로 변환하려고 시도하여 예외가 발생합니다.
            int num = Integer.parseInt("ABC");
        } catch (NumberFormatException e) {
            // 숫자 형식 변환 오류 발생 시 이를 잡아내어 알림 메시지를 출력합니다.
            System.out.println("숫자로 변환할 수 없습니다.");
        }
    }
}
