package week09.day2;

import java.util.function.BiFunction;

public class Answer5_1 {
    public static void main(String[] args) {
        // BiFunction은 두 개의 인자(Double, Double)를 받아 결과(Double)를 반환하는 함수형 인터페이스입니다.
        // 두 개의 실수를 받아 더 큰 값을 반환하는 기능을 Double 클래스의 max 메서드 참조(Method Reference)를 활용하여 구현합니다.
        BiFunction<Double, Double, Double> maxFinder = Double::max;

        // apply 메서드를 사용하여 두 실수(3.5, 7.2) 중 더 큰 값을 계산하고 출력합니다. (예상결과: 7.2)
        System.out.println("최댓값 검사(3.5, 7.2): " + maxFinder.apply(3.5, 7.2)); // 7.2
        
        // apply 메서드를 사용하여 두 실수(-1.5, -5.0) 중 더 큰 값을 계산하고 출력합니다. (예상결과: -1.5)
        System.out.println("최댓값 검사(-1.5, -5.0): " + maxFinder.apply(-1.5, -5.0)); // -1.5
    }
}
