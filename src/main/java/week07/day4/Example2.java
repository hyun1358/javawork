package week07.day4;

/**
 * [학습 예제 2] Week 07 Day 4 — 사용자 정의 예외(Custom Exception) 설계
 * 
 * [학습 핵심 이론: 비즈니스에 맞는 커스텀 예외 클래스 설계]
 * 1. 커스텀 예외(Custom Exception)의 필요성:
 *    - 도메인 특화 이름을 가진 예외 클래스를 직접 설계하여 가독성을 높이고, 에러 코드(ErrorCode)나 실패 데이터를 함께 담아 보낼 수 있습니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: InvalidAgeException (나이 범위 검증 예외) (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab2: InvalidAgeException (나이 범위 검증 예외) (Problem 2 연계) ---");
        Lab2.run();
    }

    // Problem 2: InvalidAgeException 커스텀 예외 정의
    static class InvalidAgeException extends RuntimeException {
        private final int errorCode;

        public InvalidAgeException(String message, int errorCode) {
            super(message);
            this.errorCode = errorCode;
        }

        public int getErrorCode() { return errorCode; }
    }

    static class Lab2 {
        static void run() {
            int age = -5;
            try {
                System.out.println("가입자 나이 검증: " + age);
                if (age <= 0) {
                    throw new InvalidAgeException("나이는 0보다 커야 합니다.", 400);
                }
            } catch (InvalidAgeException e) {
                System.out.println("예외 포착! 메시지: " + e.getMessage() + " | 에러코드: " + e.getErrorCode());
            }
        }
    }
}
