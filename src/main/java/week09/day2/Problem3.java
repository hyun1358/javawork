package week09.day2;

import java.util.function.Consumer;

/**
 * [연습 문제 3] Consumer로 출력
 * 문제: 입력받은 숫자를 "입력값: N" 형태로 출력하는 Consumer<Integer>를 작성하세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        Consumer<Integer> print = n -> System.out.println("입력값: " + n);
        print.accept(20);
    }
}
