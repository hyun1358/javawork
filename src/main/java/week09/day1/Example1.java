package week09.day1;

/**
 * [학습 예제 1] Week 09 Day 1 — 람다식(Lambda Expression)과 함수형 인터페이스
 * 
 * [학습 핵심 이론: 자바의 함수형 프로그래밍 지원 - 람다]
 * 1. 함수형 인터페이스 (Functional Interface):
 *    - 단 하나의 추상 메서드만 정의되어 있는 인터페이스를 뜻합니다.
 *    - `@FunctionalInterface` 어노테이션을 붙여 컴파일러가 규격을 강제하게 할 수 있습니다. 람다식은 이 인터페이스의 익명 구현 객체로 취급됩니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: 커스텀 @FunctionalInterface 생성 및 최댓값(getMax) 람다 구현 (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: 커스텀 @FunctionalInterface 생성 및 최댓값(getMax) 람다 구현 (Problem 1 연계) ---");
        Lab1.run();
    }

    // Problem 1: 커스텀 함수형 인터페이스 정의
    @FunctionalInterface
    interface MyFun {
        int getMax(int a, int b);
    }

    static class Lab1 {
        static void run() {
            // 람다식을 이용한 익명 구현 객체 매핑
            MyFun myfun = (a, b) -> a > b ? a : b;
            int result = myfun.getMax(15, 20);
            System.out.println("15와 20 중 최댓값: " + result);
        }
    }
}
