package week09.day2;

import java.util.function.Supplier;

/**
 * [연습 문제 4] Supplier 랜덤 생성
 * 문제: 1부터 10 사이의 정수 난수를 반환하는 Supplier<Integer>를 작성하세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        Supplier<Integer> random = () -> (int)((Math.random()*10) + 1);
        System.out.println(random.get());
    }
}
