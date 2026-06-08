package week09.day2;

import java.util.function.BiFunction;

/**
 * [학습 예제 5] Week 09 Day 2 — 표준 함수형 인터페이스 활용
 * 
 * [학습 핵심 이론: java.util.function 패키지의 표준 API]
 * 5. BiFunction<T, U, R> (이항 변환자):
 *    - `<T>`와 `<U>` 두 개의 매개변수를 입력받아 연산하여 `<R>` 타입을 리턴합니다.
 *    - 실행 메서드: `.apply(t, u)` (Problem 5 연계)
 * 
 * [문제별 학습 목표]
 * - Lab5: BiFunction<Double, Double, Double>을 통한 실수 덧셈 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab5: BiFunction<Double, Double, Double>을 통한 실수 덧셈 (Problem 5 연계) ---");
        Lab5.run();
    }

    static class Lab5 {
        static void run() {
            // Problem 5: 두 실수를 받아 더한 값을 반환
            BiFunction<Double, Double, Double> sumDouble = (n1, n2) -> n1 + n2;
            double a = 10.5;
            double b = 20.3;
            double result = sumDouble.apply(a, b);
            System.out.printf("%.2f + %.2f = %.2f\n", a, b, result);
        }
    }
}
