package week09.day2;

import java.util.function.Function;

public class Answer2_1 {
    public static void main(String[] args) {
        // Function은 하나의 인자(String)를 받아 결과를 반환(Integer)하는 함수형 인터페이스입니다.
        // 문자열을 받아 길이를 반환하는 기능을 String 클래스의 length 메서드 참조(Method Reference)를 활용하여 구현합니다.
        Function<String, Integer> stringLength = String::length;

        // apply 메서드를 사용하여 주어진 문자열("hello")의 길이를 계산하고 출력합니다. (예상결과: 5)
        System.out.println("문자열 길이('hello'): " + stringLength.apply("hello")); // 5
        
        // apply 메서드를 사용하여 주어진 문자열("java")의 길이를 계산하고 출력합니다. (예상결과: 4)
        System.out.println("문자열 길이('java'): " + stringLength.apply("java"));   // 4
    }
}
