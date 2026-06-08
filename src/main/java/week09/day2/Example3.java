package week09.day2;

import java.util.function.Consumer;

/**
 * [학습 예제 3] Week 09 Day 2 — 표준 함수형 인터페이스 활용
 * 
 * [학습 핵심 이론: java.util.function 패키지의 표준 API]
 * 3. Consumer<T> (소비자):
 *    - `<T>` 타입 입력값을 받아서 사용만 하고 아무것도 돌려주지 않습니다 (리턴타입 void).
 *    - 실행 메서드: `.accept(value)` (Problem 3 연계)
 * 
 * [문제별 학습 목표]
 * - Lab3: Consumer<Integer>를 활용한 입력값 포맷팅 출력 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab3: Consumer<Integer>를 활용한 입력값 포맷팅 출력 (Problem 3 연계) ---");
        Lab3.run();
    }

    static class Lab3 {
        static void run() {
            // Problem 3: 입력 숫자를 포맷에 맞춰 출력
            Consumer<Integer> print = n -> System.out.println("입력값: " + n);
            print.accept(20);
            print.accept(100);
        }
    }
}
