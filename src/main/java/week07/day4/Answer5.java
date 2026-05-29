package week07.day4;

/**
 * 예외 객체의 다양한 메서드를 활용하여 에러 정보를 확인하는 예제입니다.
 */
public class Answer5 {
    public static void main(String[] args) {
        try {
            // 산술 연산 예외(ArithmeticException)를 발생시킵니다.
            int a = 1 / 0;
        } catch (Exception e) {
            // getMessage(): 예외의 간단한 에러 메시지를 반환합니다.
            System.out.println("getMessage: " + e.getMessage());
            // toString(): 예외 클래스 이름과 에러 메시지를 함께 반환합니다.
            System.out.println("toString: " + e.toString());
            // printStackTrace(): 예외 발생 위치와 호출 스택(Call Stack) 정보를 표준 에러 출력으로 내보냅니다.
            System.out.println("printStackTrace: ");
            e.printStackTrace();
        }
    }
}
