package week07.day1;

/**
 * [예습 파일] Week 07 Day 1 — 예외 처리 기초
 */
public class Preview {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
            System.out.println("결과: " + result);
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다! " + e.getMessage());
        }
        System.out.println("프로그램 정상 종료");
    }
}
