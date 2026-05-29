package week07.day3;

/**
 * throw 키워드를 사용하여 예외를 직접 발생시키는 예제입니다.
 */
public class Answer1 {
    public static void main(String[] args) {
        try {
            // validate 메서드에 음수를 전달하여 고의로 예외를 발생시킵니다.
            validate(-10);
        } catch (Exception e) {
            // 발생한 예외의 메시지를 출력합니다.
            System.out.println(e.getMessage());
        }
    }

    public static void validate(int n) {
        // n이 0보다 작으면 throw 키워드를 사용하여 IllegalArgumentException 예외를 인위적으로 발생시킵니다.
        if (n < 0) throw new IllegalArgumentException("음수 불가");
    }
}
