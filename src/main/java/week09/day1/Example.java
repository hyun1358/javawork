package week09.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * [학습 예제] Week 09 Day 1 — 람다식(Lambda Expression)과 함수형 인터페이스 (Custom 함수형 인터페이스, 문자열 길이 정렬, Runnable 람다화, 메서드 참조 ::, 람다 변수 저장 및 루프 호출)
 * 
 * [학습 핵심 이론: 자바의 함수형 프로그래밍 지원 - 람다]
 * 1. 함수형 인터페이스 (Functional Interface):
 *    - 단 하나의 추상 메서드만 정의되어 있는 인터페이스를 뜻합니다.
 *    - `@FunctionalInterface` 어노테이션을 붙여 컴파일러가 규격을 강제하게 할 수 있습니다. 람다식은 이 인터페이스의 익명 구현 객체로 취급됩니다. (Problem 1, 5 연계)
 * 
 * 2. 람다식 (Lambda Expression, `(parameters) -> { body }`):
 *    - 익명 클래스의 불필요한 보일러플레이트 코드(메서드명 선언 등)를 걷어내고, 메서드를 하나의 간결한 '식(Expression)'으로 표현한 익명 함수입니다. (Problem 2, 3 연계)
 * 
 * 3. 메서드 참조 (Method Reference, `::`):
 *    - 람다식이 인자값을 전달받아 아무 가공 없이 그대로 다른 메서드의 인자로 토스하기만 할 때, 코드를 극단적으로 단축하는 문법입니다.
 *    - `System.out::println`은 `(x) -> System.out.println(x)`와 완전히 100% 동일하게 동작합니다. (Problem 4 연계)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 09 Day 1 학습 예제 ===\n");

        System.out.println("--- Lab1: 커스텀 @FunctionalInterface 생성 및 최댓값(getMax) 람다 구현 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: 문자열 리스트의 길이(length) 기준 다형적 람다 정렬 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: 익명 클래스 vs 람다식 Runnable 생성 및 동작 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: 람다식에서 메서드 참조(System.out::println)로의 우아한 축소 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: 람다식을 커스텀 인터페이스 변수에 보관 후 반복문 호출 (Problem 5 연계) ---");
        Lab5.run();
    }

    // Problem 1: 커스텀 함수형 인터페이스 정의
    @FunctionalInterface
    interface MyFun {
        int getMax(int a, int b);
    }

    // Problem 5: 람다식을 보관할 전용 인터페이스 정의
    @FunctionalInterface
    interface Printer {
        void print(String msg);
    }

    static class Lab1 {
        static void run() {
            // 람다식을 이용한 익명 구현 객체 매핑
            MyFun myfun = (a, b) -> a > b ? a : b;
            int result = myfun.getMax(15, 20);
            System.out.println("15와 20 중 최댓값: " + result);
        }
    }

    static class Lab2 {
        static void run() {
            // Problem 2: 문자열 리스트를 길이 순으로 정렬
            List<String> fruits = new ArrayList<>(Arrays.asList("asd", "asdasd", "asgdff", "adtsafertg"));
            System.out.println("정렬 전: " + fruits);

            // 람다식을 이용해 Comparator 인터페이스의 compare() 메서드 완성
            fruits.sort((s1, s2) -> s1.length() - s2.length());
            System.out.println("길이 기준 오름차순 정렬 후: " + fruits);
        }
    }

    static class Lab3 {
        static void run() {
            // Problem 3: Runnable 람다
            // 1. 기존의 지저분한 익명 클래스 방식
            Runnable runnableOld = new Runnable() {
                @Override
                public void run() {
                    System.out.println("[익명 클래스] Hello Old Java!");
                }
            };
            runnableOld.run();

            // 2. 현대적이고 가독성 높은 람다식 방식
            Runnable runnableNew = () -> System.out.println("[람다식 방식] Hello Lambda!");
            runnableNew.run();
        }
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

    static class Lab5 {
        static void run() {
            // Problem 5: 람다식을 인터페이스 변수에 담고, 루프 안에서 3번 호출
            Printer p = msg -> System.out.println("[Printer 출력] " + msg);

            System.out.println("반복문을 시작합니다...");
            for (int i = 1; i <= 3; i++) {
                p.print("반복 카운트: " + i);
            }
        }
    }
}
