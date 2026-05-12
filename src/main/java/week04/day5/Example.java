package week04.day5;

/**
 * [학습 예제] Week 04 Day 5 — Javadoc과 유효성 검사
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: Javadoc 주석 연습 ===");
        System.out.println("10 + 20 = " + add(10, 20));

        System.out.println("\n=== Lab2: 유효성 검사 메서드 ===");
        checkAge(20);
        // checkAge(-5); // 에러 메시지 출력
    }

    /**
     * 두 정수의 합을 구합니다.
     *
     * @param a 첫 번째 정수
     * @param b 두 번째 정수
     * @return 두 정수의 합계
     */
    public static int add(int a, int b) {
        return a + b;
    }

    public static void checkAge(int age) {
        if (age < 0 || age > 150) {
            System.out.println("오류: 나이가 유효하지 않습니다.");
            return;
        }
        System.out.println("나이 " + age + "세, 유효한 입력입니다.");
    }
}
