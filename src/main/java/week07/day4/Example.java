package week07.day4;

/**
 * [학습 예제] Week 07 Day 4 — RuntimeException 기반 사용자 정의 예외 + 정보 추가
 */
public class Example {
    public static void main(String[] args) {
        try {
            login("user123");
        } catch (InvalidUserException e) {
            System.out.println("에러 코드: " + e.getErrorCode());
            System.out.println("에러 메시지: " + e.getMessage());
        }
    }

    public static void login(String id) {
        if (id.length() < 8) {
            throw new InvalidUserException("아이디가 너무 짧습니다.", 401);
        }
    }
}

class InvalidUserException extends RuntimeException {
    private int errorCode;

    public InvalidUserException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
