package week09.day2;

import java.util.function.Predicate;

public class Answer1_1 {
    public static void main(String[] args) {
        // Predicate는 하나의 인자를 받아 조건에 맞는지 판별(boolean 반환)하는 함수형 인터페이스입니다.
        // 숫자가 음수(0보다 작은 수)인지 판별하는 람다식을 작성합니다. (n < 0 이면 true)
        Predicate<Integer> isNegative = n -> n < 0;

        // test 메서드를 사용하여 주어진 숫자(-10)가 조건(음수)에 맞는지 판별하고 출력합니다. (예상결과: true)
        System.out.println("음수 검사(-10): " + isNegative.test(-10)); // true
        
        // test 메서드를 사용하여 주어진 숫자(5)가 조건(음수)에 맞는지 판별하고 출력합니다. (예상결과: false)
        System.out.println("음수 검사(5): " + isNegative.test(5));   // false
    }
}
