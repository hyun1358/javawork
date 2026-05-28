package week09.day2;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * [학습 예제] Week 09 Day 2 — 표준 함수형 인터페이스 활용 (Predicate 양수판별, Function 대문자변환, Consumer 포맷출력, Supplier 랜덤정수, BiFunction 실수더하기)
 * 
 * [학습 핵심 이론: java.util.function 패키지의 표준 API]
 * 1. Predicate<T> (판별자):
 *    - `<T>` 타입 입력값을 받아 조건식을 평가한 뒤 `boolean`을 리턴합니다.
 *    - 실행 메서드: `.test(value)` (Problem 1 연계)
 * 
 * 2. Function<T, R> (변환자):
 *    - `<T>` 타입 입력값을 받아 가공하여 `<R>` 타입 결과값으로 변환(Mapping) 리턴합니다.
 *    - 실행 메서드: `.apply(value)` (Problem 2 연계)
 * 
 * 3. Consumer<T> (소비자):
 *    - `<T>` 타입 입력값을 받아서 사용만 하고 아무것도 돌려주지 않습니다 (리턴타입 void).
 *    - 실행 메서드: `.accept(value)` (Problem 3 연계)
 * 
 * 4. Supplier<T> (공급자):
 *    - 매개변수를 받지 않고, 호출할 때마다 `<T>` 타입 객체를 생성하거나 획득하여 반환합니다.
 *    - 실행 메서드: `.get()` (Problem 4 연계)
 * 
 * 5. BiFunction<T, U, R> (이항 변환자):
 *    - `<T>`와 `<U>` 두 개의 매개변수를 입력받아 연산하여 `<R>` 타입을 리턴합니다.
 *    - 실행 메서드: `.apply(t, u)` (Problem 5 연계)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 09 Day 2 학습 예제 ===\n");

        System.out.println("--- Lab1: Predicate<Integer>를 이용한 양수 판별 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: Function<String, String>과 메서드 참조 대문자 변환 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: Consumer<Integer>를 활용한 입력값 포맷팅 출력 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: Supplier<Integer>를 이용한 1~10 정수 난수 생성 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: BiFunction<Double, Double, Double>을 통한 실수 덧셈 (Problem 5 연계) ---");
        Lab5.run();
    }

    static class Lab1 {
        static void run() {
            // Problem 1: 숫자가 양수인지 판별 (n > 0)
            Predicate<Integer> isPositive = n -> n > 0;
            System.out.println("5는 양수인가? " + isPositive.test(5));
            System.out.println("-3은 양수인가? " + isPositive.test(-3));
        }
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

    static class Lab3 {
        static void run() {
            // Problem 3: 입력 숫자를 포맷에 맞춰 출력
            Consumer<Integer> print = n -> System.out.println("입력값: " + n);
            print.accept(20);
            print.accept(100);
        }
    }

    static class Lab4 {
        static void run() {
            // Problem 4: 1부터 10 사이의 정수 난수 공급자
            Supplier<Integer> randomTen = () -> (int) (Math.random() * 10) + 1;
            System.out.println("첫 번째 공급된 난수: " + randomTen.get());
            System.out.println("두 번째 공급된 난수: " + randomTen.get());
        }
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
