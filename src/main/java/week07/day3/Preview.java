package week07.day3;

/**
 * [예습 파일] Week 07 Day 3 — throw와 throws
 */
public class Preview {
    public static void main(String[] args) {
        try {
            checkAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("예외 처리 완료: " + e.getMessage());
        }
    }

    // 예외를 직접 발생시켜 위로 던집니다.
    public static void checkAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("나이는 음수가 될 수 없습니다.");
        }
        System.out.println("나이 유효");
    }
}
