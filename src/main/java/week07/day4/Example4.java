package week07.day4;

/**
 * [학습 예제 4] Week 07 Day 4 — 사용자 정의 예외(Custom Exception) 설계
 * 
 * [학습 핵심 이론: 비즈니스에 맞는 커스텀 예외 클래스 설계]
 * 3. 예외 계층 구조 (Exception Hierarchy):
 *    - 시스템 최상위 에러(`AppError`)를 선언하고, 그 아래 도메인별 구체적 자식 에러(`DbError`, `NetworkError` 등)를 상속 배치하여 부모 타입으로 에러를 통합 분류 처리할 수 있습니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: Custom 예외 계층 구조 (AppError -> DbError) 활용 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab4: Custom 예외 계층 구조 (AppError -> DbError) 활용 (Problem 4 연계) ---");
        Lab4.run();
    }

    // Problem 4: 예외 계층 구조 정의
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
}
