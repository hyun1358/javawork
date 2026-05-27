package week09.day2;

import java.util.function.Predicate;

/**
 * [보충 연습 문제 1-1] Predicate 사용
 * 문제: 숫자가 음수(0보다 작은 수)인지 판별하는 Predicate를 작성하고 테스트하세요.
 */
public class Problem1_1 {
    public static void main(String[] args)
    {
        // TODO
        Predicate<Integer> mius = n -> n < 0;
        System.out.println(mius.test(-1));
        System.out.println(mius.test(5));
    }
}
