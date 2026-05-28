package week07.day4;

/**
 * [학습 예제] Week 07 Day 4 — 사용자 정의 예외(Custom Exception) 설계 (InsufficientBalanceException 잔액부족, InvalidAgeException 나이검사, InvalidUserIdLengthException 아이디검사, AppError-DbError 계층화, 예외메시지 패턴 비교)
 * 
 * [학습 핵심 이론: 비즈니스에 맞는 커스텀 예외 클래스 설계]
 * 1. 커스텀 예외(Custom Exception)의 필요성:
 *    - 자바 기본 예외(NullPointerException, IllegalArgumentException 등)로는 도메인 비즈니스적 오류 상황(예: 잔액 부족, 로그인 제한 등)을 명확하게 묘사하기 어렵습니다.
 *    - 도메인 특화 이름을 가진 예외 클래스를 직접 설계하여 가독성을 높이고, 에러 코드(ErrorCode)나 실패 데이터를 함께 담아 보낼 수 있습니다.
 * 
 * 2. Unchecked Custom Exception (`extends RuntimeException`):
 *    - `RuntimeException`을 부모로 상속하여 생성합니다.
 *    - 호출 메서드에서 예외 처리를 컴파일러가 강제하지 않으므로 결합도가 낮고 모던 자바 실무 설계에서 가장 널리 선언되는 형태입니다. (Problem 1, 2, 3 연계)
 * 
 * 3. 예외 계층 구조 (Exception Hierarchy):
 *    - 시스템 최상위 에러(`AppError`)를 선언하고, 그 아래 도메인별 구체적 자식 에러(`DbError`, `NetworkError` 등)를 상속 배치하여 부모 타입으로 에러를 통합 분류 처리할 수 있습니다. (Problem 4 연계)
 * 
 * 4. 예외 정보 출력 패턴의 구분:
 *    - `e.getMessage()`: 발생 사유 문자열만 간단히 조회.
 *    - `e.toString()`: 예외의 풀 패키지 클래스명과 메시지를 조합해 한 줄 조회.
 *    - `e.printStackTrace()`: 에러가 발생한 소스코드의 구체적인 추적 흐름(스택 트레이스)을 전체 로깅. (Problem 5 연계)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 07 Day 4 학습 예제 ===\n");

        System.out.println("--- Lab1: InsufficientBalanceException (잔액 부족 예외) (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: InvalidAgeException (나이 범위 검증 예외) (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: InvalidUserIdLengthException (ID 길이 제한 예외) (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: Custom 예외 계층 구조 (AppError -> DbError) 활용 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: e.getMessage() vs e.toString() vs e.printStackTrace() 상세 비교 (Problem 5 연계) ---");
        Lab5.run();
    }

    // Problem 1: InsufficientBalanceException 커스텀 예외 정의
    static class InsufficientBalanceException extends RuntimeException {
        private final int errorCode;

        public InsufficientBalanceException(String message, int errorCode) {
            super(message);
            this.errorCode = errorCode;
        }

        public int getErrorCode() { return errorCode; }
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

    // Problem 3: InvalidUserIdLengthException 커스텀 예외 정의
    static class InvalidUserIdLengthException extends RuntimeException {
        private final int errorCode;

        public InvalidUserIdLengthException(String message, int errorCode) {
            super(message);
            this.errorCode = errorCode;
        }

        public int getErrorCode() { return errorCode; }
    }

    // Problem 4, 5: 예외 계층 구조 정의
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

    static class Lab1 {
        static void run() {
            int balance = 100;
            int withdrawAmount = 250;
            try {
                System.out.println("현재 잔액: " + balance + "원 | 출금 시도액: " + withdrawAmount + "원");
                if (balance < withdrawAmount) {
                    throw new InsufficientBalanceException("계좌 잔액이 부족하여 출금할 수 없습니다.", 402);
                }
            } catch (InsufficientBalanceException e) {
                System.out.println("예외 포착! 메시지: " + e.getMessage() + " | 에러코드: " + e.getErrorCode());
            }
        }
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

    static class Lab4 {
        static void run() {
            try {
                // 자식 예외 DbError 강제 발생
                System.out.println("데이터베이스 쿼리 중 예외 발생 시뮬레이션...");
                throw new DbError("데이터베이스 커넥션 풀이 꽉 찼습니다.", 503);
            } 
            // 부모 타입인 AppError로 잡아도 자식 타입 DbError가 문제없이 포착됨을 검증
            catch (AppError e) {
                System.out.println("[AppError 통합 핸들러] 예외 포착!");
                System.out.println("클래스 형태: " + e.getClass().getSimpleName());
                System.out.println("메시지: " + e.getMessage() + " | 에러코드: " + e.getErrorCode());
            }
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
