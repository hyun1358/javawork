package week09.day2;

import java.util.function.Predicate;

public class Answer1_1 {
    public static void main(String[] args) {
        // 숫자가 음수(0보다 작은 수)인지 판별하는 Predicate 작성
        Predicate<Integer> isNegative = n -> n < 0;

        // 출력 테스트
        System.out.println("음수 검사(-10): " + isNegative.test(-10)); // true
        System.out.println("음수 검사(5): " + isNegative.test(5));   // false
    }
}
