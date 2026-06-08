package week09.day2;

import java.util.function.Function;

/**
 * [학습 예제 2] Week 09 Day 2 — 표준 함수형 인터페이스 활용
 * 
 * [학습 핵심 이론: java.util.function 패키지의 표준 API]
 * 2. Function<T, R> (변환자):
 *    - `<T>` 타입 입력값을 받아 가공하여 `<R>` 타입 결과값으로 변환(Mapping) 리턴합니다.
 *    - 실행 메서드: `.apply(value)` (Problem 2 연계)
 * 
 * [문제별 학습 목표]
 * - Lab2: Function<String, String>과 메서드 참조 대문자 변환 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab2: Function<String, String>과 메서드 참조 대문자 변환 (Problem 2 연계) ---");
        Lab2.run();
    }

    static class Lab2 {
        static void run() {
            // Problem 2: 문자열을 받아 대문자로 변환
            Function<String, String> uppercase = String::toUpperCase;
            String original = "antigravity";
            String result = uppercase.apply(original);
            System.out.printf("원본: \"%s\" -> 변환 결과: \"%s\"\n", original, result);
        }
    }
}
