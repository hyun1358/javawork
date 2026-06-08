package week09.day2;

import java.util.function.Supplier;

/**
 * [학습 예제 4] Week 09 Day 2 — 표준 함수형 인터페이스 활용
 * 
 * [학습 핵심 이론: java.util.function 패키지의 표준 API]
 * 4. Supplier<T> (공급자):
 *    - 매개변수를 받지 않고, 호출할 때마다 `<T>` 타입 객체를 생성하거나 획득하여 반환합니다.
 *    - 실행 메서드: `.get()` (Problem 4 연계)
 * 
 * [문제별 학습 목표]
 * - Lab4: Supplier<Integer>를 이용한 1~10 정수 난수 생성 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab4: Supplier<Integer>를 이용한 1~10 정수 난수 생성 (Problem 4 연계) ---");
        Lab4.run();
    }

    static class Lab4 {
        static void run() {
            // Problem 4: 1부터 10 사이의 정수 난수 공급자
            Supplier<Integer> randomTen = () -> (int) (Math.random() * 10) + 1;
            System.out.println("첫 번째 공급된 난수: " + randomTen.get());
            System.out.println("두 번째 공급된 난수: " + randomTen.get());
        }
    }
}
