package week09.day2;

import java.util.function.Predicate;
import java.util.function.Function;

/**
 * [예습 파일] Week 09 Day 2 — java.util.function 패키지
 */
public class Preview {
    public static void main(String[] args) {
        // Predicate: 입력값을 받아 boolean 반환 (조건 검사)
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("4는 짝수인가? " + isEven.test(4));

        // Function: 입력값을 받아 변환된 값을 반환
        Function<String, Integer> lengthFunc = str -> str.length();
        System.out.println("문자열 길이: " + lengthFunc.apply("Java"));
    }
}
