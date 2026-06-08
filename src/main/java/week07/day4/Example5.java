package week07.day4;

/**
 * [학습 예제 5] Week 07 Day 4 — 사용자 정의 예외(Custom Exception) 설계
 * 
 * [학습 핵심 이론: 비즈니스에 맞는 커스텀 예외 클래스 설계]
 * 4. 예외 정보 출력 패턴의 구분:
 *    - `e.getMessage()`: 발생 사유 문자열만 간단히 조회.
 *    - `e.toString()`: 예외의 풀 패키지 클래스명과 메시지를 조합해 한 줄 조회.
 *    - `e.printStackTrace()`: 에러가 발생한 소스코드의 구체적인 추적 흐름(스택 트레이스)을 전체 로깅.
 * 
 * [문제별 학습 목표]
 * - Lab5: e.getMessage() vs e.toString() vs e.printStackTrace() 상세 비교 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab5: e.getMessage() vs e.toString() vs e.printStackTrace() 상세 비교 (Problem 5 연계) ---");
        Lab5.run();
    }

    // 예외 계층 구조 정의
    static class AppError extends RuntimeException {
        private final int errorCode;

        public AppError(String message, int errorCode) {
            super(message);
            this.errorCode = errorCode;
        }

        public int getErrorCode() { return errorCode; }
    }

    static class DbError extends AppError {
        public DbError(String message, int errorCode) {
            super(message, errorCode);
        }
    }

    static class Lab5 {
        static void run() {
            try {
                throw new DbError("SQL Syntax Error 발생", 500);
            } catch (AppError e) {
                System.out.println("1. e.getMessage(): " + e.getMessage());
                System.out.println("----------------------------------------------");
                System.out.println("2. e.toString(): " + e.toString());
                System.out.println("----------------------------------------------");
                System.out.println("3. e.printStackTrace() 출력:");
                e.printStackTrace(); // 콘솔에 빨간 추적 로그를 비동기식으로 뿌림
            }
        }
    }
}
