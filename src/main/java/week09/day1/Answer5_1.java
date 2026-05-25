package week09.day1;

import java.util.function.Function;

public class Answer5_1 {
    public static void main(String[] args) {
        // 정수(Integer)를 입력받아 그 수의 제곱(x * x)을 반환하는 람다식을 
        // 자바 표준 함수형 인터페이스인 Function<Integer, Integer>에 담습니다.
        Function<Integer, Integer> square = x -> x * x;

        // for문을 사용하여 1부터 5까지의 수에 대해 람다식을 호출하고 결과를 출력합니다.
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + "의 제곱: " + square.apply(i));
        }
    }
}
