package week09.day2;

import java.util.function.BiFunction;

/**
 * [연습 문제 5] BiFunction 사용
 * 문제: 두 개의 실수를 받아 더한 값을 반환하는 BiFunction<Double, Double, Double>을 작성하세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        BiFunction<Double,Double,Double> sum = (n1 , n2) -> n1+n2;
        System.out.println(sum.apply(10.0,20.0));
    }
}
