package week09.day2;

import java.util.function.Predicate;

public class Answer1 {
    public static void main(String[] args) {
        // Predicate는 하나의 인자를 받아 boolean 값을 반환하는 함수형 인터페이스입니다.
        // 이 람다식은 입력된 정수(n)가 0보다 큰지 검사하여 양수이면 true, 아니면 false를 반환합니다.
        Predicate<Integer> isPositive = n -> n > 0;
        
        // test 메서드를 호출하여 10이 양수인지 판별하고 그 결과를 출력합니다.
        System.out.println("양수 검사: " + isPositive.test(10));
        
        // test 메서드를 호출하여 -5가 양수인지 판별하고 그 결과를 출력합니다.
        System.out.println("양수 검사: " + isPositive.test(-5));
    }
}
