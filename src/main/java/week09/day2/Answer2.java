package week09.day2;

import java.util.function.Function;

public class Answer2 {
    public static void main(String[] args) {
        // Function은 하나의 인자(T)를 받아 결과를 반환(R)하는 함수형 인터페이스입니다.
        // 이 람다식은 문자열(String)을 입력받아 대문자로 변환된 문자열(String)을 반환합니다.
        Function<String, String> toUpper = str -> str.toUpperCase();
        
        // apply 메서드를 호출하여 "java" 문자열을 대문자로 변환하고 그 결과를 출력합니다.
        System.out.println(toUpper.apply("java"));
    }
}
