package week09.day2;

import java.util.function.BiFunction;

/**
 * [보충 연습 문제 5-1] BiFunction과 메서드 참조 사용
 * 문제: 두 개의 실수를 받아 더 큰 값을 반환하는 BiFunction<Double, Double, Double>을 작성하세요.
 *       (단, Double 클래스의 max 메서드 참조를 적용하여 구현하세요.)
 */
public class Problem5_1 {
    public static void main(String[] args)
    {
        // TODO
        BiFunction<Double,Double,Double> max = Double::max;
        System.out.println(max.apply(21.3,20.3));
    }
}
