package week01.day2;

/**
 * [학습 예제] Week 01 Day 2 — 변수와 자료형 기초
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 01 Day 2 학습 예제 ===\n");

        System.out.println("--- Lab1: 변수 선언과 값 대입 ---");
        Lab1.run();
        System.out.println("\n[해설] 변수 선언 시 '자료형 변수명 = 값;' 형식을 사용합니다.\n");

        System.out.println("--- Lab2: 정수형 (int, long) ---");
        Lab2.run();
        System.out.println("\n[해설] 기본 정수는 int를 사용하며, 아주 큰 수는 long(L 접미사 필수)을 사용합니다.\n");

        System.out.println("--- Lab3: 실수형 (double, float) ---");
        Lab3.run();
        System.out.println("\n[해설] 소수점은 기본적으로 double을 사용합니다.\n");

        System.out.println("--- Lab4: 문자형 (char) ---");
        Lab4.run();
        System.out.println("\n[해설] char는 문자 하나를 작은따옴표(' ')로 감쌉니다.\n");

        System.out.println("--- Lab5: 논리형(boolean)과 문자열(String) ---");
        Lab5.run();
        System.out.println("\n[해설] boolean은 true/false만 가지며, String은 문자열을 저장합니다.\n");
    }

    static class Lab1 {
        static void run() {
            int score; // 선언
            score = 100; // 대입
            System.out.println("점수: " + score);
        }
    }

    static class Lab2 {
        static void run() {
            int num1 = 2100000000;
            long num2 = 3000000000L; // L을 붙여야 long으로 인식
            System.out.println("int: " + num1);
            System.out.println("long: " + num2);
        }
    }

    static class Lab3 {
        static void run() {
            double pi = 3.141592;
            float weight = 70.5f; // f를 붙여야 float으로 인식
            System.out.println("double: " + pi);
            System.out.println("float: " + weight);
        }
    }

    static class Lab4 {
        static void run() {
            char grade = 'A';
            System.out.println("등급: " + grade);
        }
    }

    static class Lab5 {
        static void run() {
            boolean isHappy = true;
            String message = "Hello Java";
            System.out.println("행복여부: " + isHappy);
            System.out.println("메시지: " + message);
        }
    }
}
