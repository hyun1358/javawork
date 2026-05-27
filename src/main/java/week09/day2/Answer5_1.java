package week09.day2;

import java.util.function.BiFunction;

public class Answer5_1 {
    public static void main(String[] args) {
        // 두 개의 실수를 받아 더 큰 값을 반환하는 BiFunction 작성 (Double::max 메서드 참조 활용)
        BiFunction<Double, Double, Double> maxFinder = Double::max;

        // 출력 테스트
        System.out.println("최댓값 검사(3.5, 7.2): " + maxFinder.apply(3.5, 7.2)); // 7.2
        System.out.println("최댓값 검사(-1.5, -5.0): " + maxFinder.apply(-1.5, -5.0)); // -1.5
    }
}
