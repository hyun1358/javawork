package week09.day1;

import java.util.function.Function;

/**
 * [추가 연습 문제 5-1] 람다를 사용한 연산 수행 및 반복 호출
 * 
 * 문제:
 * 정수(Integer)를 입력받아 그 수의 제곱(square, x * x)을 반환하는 람다식을 작성하고,
 * 이를 자바의 표준 함수형 인터페이스인 Function<Integer, Integer> 타입의 변수에 저장하세요.
 * 이후, for문을 사용하여 1부터 5까지의 숫자를 대입해 각각의 제곱 결과를 출력하는 코드를 완성해 보세요.
 * 
 * 힌트:
 * 1. Function<T, R> 은 T 타입을 입력받아 R 타입을 반환합니다. 추상 메서드는 R apply(T t) 입니다.
 * 2. 람다식 식: square = x -> x * x;
 * 
 * 출력 예시:
 * 1의 제곱: 1
 * 2의 제곱: 4
 * 3의 제곱: 9
 * 4의 제곱: 16
 * 5의 제곱: 25
 */
public class Problem5_1 {
    public static void main(String[] args) {
        // TODO: Function<Integer, Integer> 변수를 선언하고 제곱을 구하는 람다식을 대입하세요.
        Function<Integer,Integer> square = n -> n*n;
        // TODO: for문을 사용하여 1부터 5까지의 수에 대해 람다식의 apply() 메서드를 호출하고 결과를 출력하세요.
        for(int i = 1; i <= 5; i++)
        {
            System.out.println(i+"의 제곱: "+square.apply(i));
        }
    }
}
