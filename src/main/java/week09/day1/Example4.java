package week09.day1;

import java.util.function.Consumer;

/**
 * [학습 예제 4] Week 09 Day 1 — 람다식(Lambda Expression)과 함수형 인터페이스
 * 
 * [학습 핵심 이론: 자바의 함수형 프로그래밍 지원 - 람다]
 * 3. 메서 참조 (Method Reference, `::`):
 *    - 람다식이 인자값을 전달받아 아무 가공 없이 그대로 다른 메서드의 인자로 토스하기만 할 때, 코드를 극단적으로 단축하는 문법입니다.
 *    - `System.out::println`은 `(x) -> System.out.println(x)`와 완전히 100% 동일하게 동작합니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: 람다식에서 메서드 참조(System.out::println)로의 우아한 축소 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab4: 람다식에서 메서드 참조(System.out::println)로의 우아한 축소 (Problem 4 연계) ---");
        Lab4.run();
    }

    static class Lab4 {
        static void run() {
            // Problem 4: 메서드 참조 변환
            // 일반 람다식 표현
            Consumer<String> standardLambda = (x) -> System.out.println(x);
            System.out.print("일반 람다식 출력: ");
            standardLambda.accept("Standard Lambda");

            // 메서드 참조(::) 표현
            Consumer<String> methodReference = System.out::println;
            System.out.print("메서드 참조 출력: ");
            methodReference.accept("Method Reference (System.out::println)");
        }
    }
}
