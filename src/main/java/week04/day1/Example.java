package week04.day1;

/**
 * [학습 예제] Week 04 Day 1 — 메서드 정의와 호출 (안녕하세요 출력, 덧셈 반환, 별 그리기, 배열 합, 최댓값 구하기)
 * 
 * [학습 핵심 이론: 코드 재사용의 기본 - 메서드]
 * 1. 메서드(Method)의 핵심 구성 요소:
 *    - 선언부(Header): 반환 타입(Return Type), 메서드 이름, 매개변수 목록(Parameter List)으로 구성됩니다.
 *    - 구현부(Body): 실행할 자바 코드 블록을 작성하며, 반환 타입이 void가 아니면 반드시 `return`문으로 결과값을 제공해야 합니다.
 * 
 * 2. 매개변수(Parameter)와 전달인자(Argument):
 *    - 매개변수는 메서드를 정의할 때 들어올 데이터 타입을 명시한 변수입니다.
 *    - 전달인자는 메서드를 실제로 호출할 때 전달하는 물리적인 실질 데이터 값입니다.
 * 
 * 3. JVM stack 영역의 동작:
 *    - 메서드가 호출되면 Call Stack에 해당 메서드만의 로컬 스택 프레임(Stack Frame)이 쌓이며, 메서드 종료 시 깨끗하게 소멸합니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 04 Day 1 학습 예제 ===\n");

        System.out.println("--- Lab1: 기본 메서드 선언과 호출 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: 매개변수와 반환값(return) (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: 특정 작업을 반복 수행하는 메서드 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: 메서드 내 로컬 배열 선언 및 합계 계산 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: 세 정수 중 최댓값 구하기 메서드 (Problem 5 연계) ---");
        Lab5.run();

        System.out.println("\n--- Lab6: Call by Value (지역 변수 스택 동작 원리) ---");
        Lab6.run();
    }

    static class Lab1 {
        static void run() {
            // Problem 1: "안녕하세요!"를 출력하는 메서드 정의 및 호출
            printHello();
        }

        static void printHello() {
            System.out.println("안녕하세요!");
        }
    }

    static class Lab2 {
        static void run() {
            // Problem 2: 두 정수를 매개변수로 받아 그 합을 반환하는 add 메서드 호출
            int sum = add(15, 25);
            System.out.println("15 + 25 = " + sum);
        }

        static int add(int a, int b) {
            return a + b; // 두 수의 합을 계산하여 반환
        }
    }

    static class Lab3 {
        static void run() {
            // Problem 3: drawStars() 메서드를 두 번 연달아 호출하여 별 그리기
            drawStars();
            drawStars();
        }

        static void drawStars() {
            System.out.println("*****"); // 별 5개를 화면에 출력
        }
    }

    static class Lab4 {
        static void run() {
            // Problem 4: 메서드 내부 지역 범위에 배열을 선언하고 그 합을 구하기
            printArraySum();
        }

        static void printArraySum() {
            int[] arr = {1, 2, 3, 4, 5};
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            System.out.println("로컬 배열 요소들의 합계: " + sum);
        }
    }

    static class Lab5 {
        static void run() {
            // Problem 5: 세 개의 정수 중 최댓값을 반환하는 max 메서드 호출
            int biggest = max(10, 25, 7);
            System.out.println("10, 25, 7 중 최댓값: " + biggest);
        }

        static int max(int a, int b, int c) {
            int maxVal = a; // 첫 번째 값을 최댓값으로 가정
            if (b > maxVal) {
                maxVal = b;
            }
            if (c > maxVal) {
                maxVal = c;
            }
            return maxVal;
        }
    }

    static class Lab6 {
        static void run() {
            int x = 10;
            updateValue(x);
            System.out.println("updateValue 호출 후 main의 x 값: " + x); // x는 여전히 10 (값 복사이므로)
        }

        static void updateValue(int x) {
            x = 20; // 이 x는 메서드 스택 프레임 내의 지역 변수이므로 외부 변수에 무해함
            System.out.println("updateValue 메서드 내부의 x 값: " + x);
        }
    }
}
