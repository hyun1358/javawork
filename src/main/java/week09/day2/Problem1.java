package week09.day2;

import java.util.function.Predicate;

/**
 * [연습 문제 1] Predicate 사용
 * 문제: 숫자가 양수인지 판별하는 Predicate를 작성하고 테스트하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        Predicate<Integer> isPositive = n -> n > 0;
        System.out.println(isPositive.test(5));
        System.out.println(isPositive.test(6));
    }
}
