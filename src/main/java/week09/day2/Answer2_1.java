package week09.day2;

import java.util.function.Function;

public class Answer2_1 {
    public static void main(String[] args) {
        // 문자열을 받아 길이를 반환하는 Function 작성 (String::length 메서드 참조 활용)
        Function<String, Integer> stringLength = String::length;

        // 출력 테스트
        System.out.println("문자열 길이('hello'): " + stringLength.apply("hello")); // 5
        System.out.println("문자열 길이('java'): " + stringLength.apply("java"));   // 4
    }
}
