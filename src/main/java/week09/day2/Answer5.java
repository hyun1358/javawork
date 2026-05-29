package week09.day2;

import java.util.function.BiFunction;

public class Answer5 {
    public static void main(String[] args) {
        // BiFunction은 두 개의 인자(T, U)를 받아 결과를 반환(R)하는 함수형 인터페이스입니다.
        // 이 람다식은 두 개의 실수(Double) a와 b를 입력받아 그 합(a + b)을 Double로 반환합니다.
        BiFunction<Double, Double, Double> adder = (a, b) -> a + b;
        
        // apply 메서드를 호출하여 3.5와 2.1을 전달하고, 두 실수의 합을 계산하여 출력합니다.
        System.out.println("합: " + adder.apply(3.5, 2.1));
    }
}
