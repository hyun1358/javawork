package week09.day2;

import java.util.function.Function;

/**
 * [보충 연습 문제 2-1] Function과 메서드 참조 사용
 * 문제: 문자열을 받아 그 길이를 반환하는 Function<String, Integer>를 작성하세요.
 *       (단, 람다 표현식이 아닌 '메서드 참조'를 적용하여 구현하세요.)
 */
public class Problem2_1 {
    public static void main(String[] args)
    {
        // TODO
        Function<String,Integer> length = String::length;
        System.out.println("문자의길이: "+ length.apply("asdasda"));
        System.out.println("문자의길이: "+ length.apply("asdasdaㅁㅇㅁㅇㅁㅇㄴㅁㅇ"));
    }
}
