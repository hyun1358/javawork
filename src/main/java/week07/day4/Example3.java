package week07.day4;

/**
 * [학습 예제 3] Week 07 Day 4 — 사용자 정의 예외(Custom Exception) 설계
 * 
 * [학습 핵심 이론: 비즈니스에 맞는 커스텀 예외 클래스 설계]
 * 1. 커스텀 예외(Custom Exception)의 필요성:
 *    - 자바 기본 예외로는 도메인 비즈니스적 오류 상황(예: 로그인 제한 등)을 명확하게 묘사하기 어렵습니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: InvalidUserIdLengthException (ID 길이 제한 예외) (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab3: InvalidUserIdLengthException (ID 길이 제한 예외) (Problem 3 연계) ---");
        Lab3.run();
    }

    // Problem 3: InvalidUserIdLengthException 커스텀 예외 정의
    static class InvalidUserIdLengthException extends RuntimeException {
        private final int errorCode;

        public InvalidUserIdLengthException(String message, int errorCode) {
            super(message);
            this.errorCode = errorCode;
        }

        public int getErrorCode() { return errorCode; }
    }

    static class Lab3 {
        static void run() {
            String userId = "java";
            try {
                System.out.println("가입 아이디 길이 검증: \"" + userId + "\"");
                if (userId.length() < 8) {
                    throw new InvalidUserIdLengthException("사용자 아이디는 최소 8자 이상이어야 합니다.", 201);
                }
            } catch (InvalidUserIdLengthException e) {
                System.out.println("예외 포착! 메시지: " + e.getMessage() + " | 에러코드: " + e.getErrorCode());
            }
        }
    }
}
