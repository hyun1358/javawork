package week07.day4;

/**
 * [학습 예제 1] Week 07 Day 4 — 사용자 정의 예외(Custom Exception) 설계
 * 
 * [학습 핵심 이론: 비즈니스에 맞는 커스텀 예외 클래스 설계]
 * 1. 커스텀 예외(Custom Exception)의 필요성:
 *    - 자바 기본 예외로는 도메인 비즈니스적 오류 상황(예: 잔액 부족)을 명확하게 묘사하기 어렵습니다.
 *    - 도메인 특화 이름을 가진 예외 클래스를 직접 설계하여 가독성을 높이고, 에러 코드(ErrorCode)나 실패 데이터를 함께 담아 보낼 수 있습니다.
 * 
 * 2. Unchecked Custom Exception (`extends RuntimeException`):
 *    - `RuntimeException`을 부모로 상속하여 생성합니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: InsufficientBalanceException (잔액 부족 예외) (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: InsufficientBalanceException (잔액 부족 예외) (Problem 1 연계) ---");
        Lab1.run();
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
}
