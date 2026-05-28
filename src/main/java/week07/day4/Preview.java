package week07.day4;

/**
 * [예습 파일] Week 07 Day 4 — 사용자 정의 예외 (Custom Exception)
 * 
 * [핵심 개념: 애플리케이션 전용 비즈니스 에러 정의]
 * 1. 커스텀 예외(Custom Exception)의 정의 목적:
 *    - 자바 기본 라이브러리가 제공하는 일반적인 예외 클래스(RuntimeException 등)만으로는 서비스 내의 독자적인 비즈니스 의미(예: 잔액 부족, 아이디 중복 등)를 직관적으로 파악하기 어렵기 때문입니다.
 *    - 도메인 전용 클래스로 에러명을 구축하여 오류의 의미와 대응책을 훨씬 명료하게 드러낼 수 있습니다.
 * 
 * 2. 예외 부모 클래스의 현명한 선택:
 *    - Exception 상속 (Checked Exception): 반드시 컴파일러 수준에서 예외 처리를 규정하므로 견고함이 필요할 때 씁니다.
 *    - RuntimeException 상속 (Unchecked Exception): 런타임에 처리해도 되며 호출 부의 예외 강제 처리를 생략해 코드가 훨씬 깔끔해지므로, 모던 자바 실무에서는 압도적으로 이 방식을 선택합니다.
 */
public class Preview {
    public static void main(String[] args) {
        try {
            withdraw(10000, 15000);
        } catch (InsufficientBalanceException e) {
            System.out.println("출금 실패: " + e.getMessage());
        }
    }

    public static void withdraw(int bal, int amt) throws InsufficientBalanceException {
        if (bal < amt) throw new InsufficientBalanceException("잔고가 부족합니다!");
        System.out.println("출금 성공");
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}
