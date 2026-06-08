package week09.day2;

import java.util.function.Predicate;

/**
 * [학습 예제 1] Week 09 Day 2 — 표준 함수형 인터페이스 활용
 * 
 * [학습 핵심 이론: java.util.function 패키지의 표준 API]
 * 1. Predicate<T> (판별자):
 *    - `<T>` 타입 입력값을 받아 조건식을 평가한 뒤 `boolean`을 리턴합니다.
 *    - 실행 메서드: `.test(value)` (Problem 1 연계)
 * 
 * [문제별 학습 목표]
 * - Lab1: Predicate<Integer>를 이용한 양수 판별 (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: Predicate<Integer>를 이용한 양수 판별 (Problem 1 연계) ---");
        Lab1.run();
    }

    static class Lab1 {
        static void run() {
            // Problem 1: 숫자가 양수인지 판별 (n > 0)
            Predicate<Integer> isPositive = n -> n > 0;
            System.out.println("5는 양수인가? " + isPositive.test(5));
            System.out.println("-3은 양수인가? " + isPositive.test(-3));
        }
    }
}
