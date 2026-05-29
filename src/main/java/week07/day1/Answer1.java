package week07.day1;

/**
 * 0으로 나누는 예외(ArithmeticException)를 처리하는 예제입니다.
 */
public class Answer1 {
    public static void main(String[] args) {
        try {
            // 5를 0으로 나누려고 시도합니다. 이는 수학적으로 불가능하여 예외를 발생시킵니다.
            int a = 5 / 0;
        } catch (ArithmeticException e) {
            // 산술 연산 오류 발생 시 이를 잡아내어 에러 메시지를 출력합니다.
            System.out.println("에러 발생! " + e.getMessage());
        }
    }
}
