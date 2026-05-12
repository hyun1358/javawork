package week07.day4;

/**
 * [예습 파일] Week 07 Day 4 — 사용자 정의 예외 (Custom Exception)
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
