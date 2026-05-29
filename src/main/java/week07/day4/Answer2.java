package week07.day4;

/**
 * RuntimeException을 상속받아 사용자 정의 예외(Unchecked Exception)를 만드는 예제입니다.
 */
public class Answer2 {
    public static void main(String[] args) {
        // 명시적으로 try-catch를 하지 않아도 컴파일이 통과되는 Unchecked 예외를 발생시킵니다.
        throw new MyUncheckedException("언체크드 예외");
    }
}

// RuntimeException을 상속받으므로 이 예외는 Unchecked 예외로 분류됩니다.
class MyUncheckedException extends RuntimeException {
    public MyUncheckedException(String m) {
        super(m); // 부모 클래스의 생성자를 호출하여 에러 메시지를 설정합니다.
    }
}
