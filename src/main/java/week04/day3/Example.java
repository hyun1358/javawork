package week04.day3;

/**
 * [학습 예제] Week 04 Day 3 — 오버로딩(Overloading)의 상세 규칙 (print, multiply, 가변 인자 매칭 우선순위, getType, area)
 * 
 * [학습 핵심 이론: 컴파일러의 메서드 시그니처 매칭 원리]
 * 1. 메서드 시그니처 (Method Signature):
 *    - 메서드 이름 + 매개변수 개수, 순서, 타입으로 구성되며, 반환 타입(Return Type)은 오버로딩 성립 조건에 전혀 관여하지 않습니다.
 * 
 * 2. 컴파일러의 오버로딩 결정 순서 (정적 바인딩):
 *    - 단계 1: 실인자(Arguments) 타입과 100% 동일한 선언을 가진 메서드를 찾습니다.
 *    - 단계 2: 동일 타입이 없다면 묵시적 형변환(Widening Conversion, e.g. int -> double)이 가능한 메서드를 매칭합니다.
 *    - 단계 3: 여전히 매칭되는 것이 없으면 가변 인자(Varargs) 메서드를 매칭합니다. (가변 인자는 가장 낮은 우선순위를 가집니다.)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 04 Day 3 학습 예제 ===\n");

        System.out.println("--- Lab1: 다양한 기본형 출력 오버로딩 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: multiply 연산 오버로딩 (2개 곱, 3개 곱, 실수 곱) (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: 가변 인자 vs 구체적인 오버로딩의 매칭 우선순위 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: 매개변수 타입에 따른 동적 메시지 getType (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: 다양한 매개변수를 가진 도형의 넓이 계산기 (Problem 5 연계) ---");
        Lab5.run();
    }

    static class Lab1 {
        static void run() {
            // Problem 1: int, double, String뿐 아니라 char, boolean을 받아 출력하는 print 구현
            print(100);
            print(3.14);
            print("자바 공부 중");
            print('A');
            print(true);
        }

        static void print(int val) { System.out.println("정수: " + val); }
        static void print(double val) { System.out.println("실수: " + val); }
        static void print(String val) { System.out.println("문자열: " + val); }
        static void print(char val) { System.out.println("문자: " + val); }
        static void print(boolean val) { System.out.println("논리값: " + val); }
    }

    static class Lab2 {
        static void run() {
            // Problem 2: 정수 2개 곱, 정수 3개 곱, 실수 2개 곱 처리
            System.out.println("5 * 8 = " + multiply(5, 8));
            System.out.println("2 * 3 * 4 = " + multiply(2, 3, 4));
            System.out.println("2.5 * 1.5 = " + multiply(2.5, 1.5));
        }

        static int multiply(int a, int b) {
            return a * b;
        }

        static int multiply(int a, int b, int c) {
            return a * b * c;
        }

        static double multiply(double a, double b) {
            return a * b;
        }
    }

    static class Lab3 {
        static void run() {
            // Problem 3: add(int, int)와 add(int... nums)가 둘 다 있을 때 호출 매칭 테스트
            // 컴파일러는 가변 인자보다 구체적으로 매칭되는 일반 메서드를 우선 선택합니다!
            int resultExact = add(1, 2);
            int resultVarargs = add(1, 2, 3, 4, 5);

            System.out.println("add(1, 2) 호출 결과: " + resultExact + " [add(int, int) 실행됨]");
            System.out.println("add(1, 2, 3, 4, 5) 호출 결과: " + resultVarargs + " [add(int...) 실행됨]");
        }

        static int add(int a, int b) {
            return a + b;
        }

        static int add(int... nums) {
            int sum = 0;
            for (int n : nums) sum += n;
            return sum;
        }
    }

    static class Lab4 {
        static void run() {
            // Problem 4: 정수/실수/문자열을 판별하는 getType
            System.out.println("getType(100) 결과: " + getType(100));
            System.out.println("getType(3.14) 결과: " + getType(3.14));
            System.out.println("getType(\"Hello\") 결과: " + getType("Hello"));
        }

        static String getType(int val) { return "정수"; }
        static String getType(double val) { return "실수"; }
        static String getType(String val) { return "문자열"; }
    }

    static class Lab5 {
        static void run() {
            // Problem 5: 원, 사각형, 삼각형 넓이 계산기 (매개변수 시그니처 구별 설계)
            System.out.println("원 넓이(반지름 5.0): " + area(5.0));
            System.out.println("사각형 넓이(10 x 20): " + area(10, 20));
            System.out.println("삼각형 넓이(밑변 10.0 x 높이 5.0): " + area(10.0, 5.0));
        }

        // 원의 넓이
        static double area(double r) {
            return Math.PI * r * r;
        }

        // 사각형의 넓이
        static int area(int w, int h) {
            return w * h;
        }

        // 삼각형의 넓이
        static double area(double base, double height) {
            return base * height / 2.0;
        }
    }
}
