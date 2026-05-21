package week09.day2;

import java.util.function.Predicate;
import java.util.function.Function;

/**
 * [예습 파일] Week 09 Day 2 — java.util.function 패키지 (표준 함수형 인터페이스)
 * 
 * 자바는 람다식을 더 편하게 쓰기 위해, 자주 사용되는 함수 형태를 미리 인터페이스로 만들어 두었습니다.
 * 매번 인터페이스를 직접 만들 필요 없이, 상황에 맞는 표준 인터페이스를 가져다 쓰면 됩니다.
 * 
 * 1. Predicate<T> (조건 검사원):
 *    - <T> 타입을 입력받아 boolean을 반환합니다.
 *    - 실행 메서드: .test(value)
 *    - 용도: "이 숫자는 짝수인가?", "이 문자열은 비어있는가?" 같은 조건 검사
 * 
 * 2. Function<T, R> (변환기):
 *    - <T> 타입을 입력받아 <R> 타입으로 변환하여 반환합니다.
 *    - 실행 메서드: .apply(value)
 *    - 용도: "문자열을 숫자로 바꾸기", "객체에서 이름만 추출하기" 등
 */
public class Preview {
    public static void main(String[] args) {
        // [Predicate 예시] 숫자가 짝수인지 검사
        // n은 입력값(Integer), -> 뒤의 조건식이 true/false를 결정합니다.
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("4는 짝수인가? " + isEven.test(4)); // true
        System.out.println("7은 짝수인가? " + isEven.test(7)); // false

        // [Function 예시] 문자열을 넣으면 그 길이를 숫자로 반환
        // <String, Integer> : String을 넣어서 Integer를 받겠다는 뜻입니다.
        Function<String, Integer> lengthFunc = str -> str.length();
        int len = lengthFunc.apply("Hello Java");
        System.out.println("문자열 길이: " + len); // 10
    }
}
