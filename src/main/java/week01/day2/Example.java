package week01.day2;

/**
 * [학습 예제] Week 01 Day 2 — 변수와 기본 자료형 및 데이터 특징
 * 
 * [학습 핵심 이론: 변수 선언과 메모리 자료형]
 * 1. 변수(Variable)의 메모리 할당:
 *    - 자료형에 따라 OS는 메모리에 고정된 바이트 크기만큼의 공간을 예약합니다.
 *    - 변수는 이 메모리 번지(Address)의 별칭 역할을 수행합니다.
 * 
 * 2. 자바의 기본 자료형 (Primitive Types)과 오버플로우:
 *    - 정수형: byte(1B), short(2B), int(4B) - 기본형, long(8B) - 접미사 L 필수.
 *    - 실수형: float(4B) - 접미사 f 필수, double(8B) - 기본형, 높은 정밀도.
 *    - 문자형: char(2B) - 홑따옴표(''), 내부적으로 유니코드 정수로 저장됨.
 *    - 논리형: boolean(1B) - true 또는 false의 값만 가짐.
 *    - **정수 오버플로우(Overflow)**: 변수가 표현할 수 있는 최대 범위를 넘어서면, 가장 최솟값으로 되돌아가 순환하는 현상입니다. (예: int 최대값 2,147,483,647 + 1 = -2,147,483,648)
 * 
 * 3. 실수 정밀도 (Precision):
 *    - float는 소수점 이하 약 7자리까지 정밀도를 보장합니다.
 *    - double은 소수점 이하 약 15자리까지 높은 정밀도를 보장하여 실무 연산에 기본 채택됩니다.
 * 
 * 4. char와 유니코드 숫자 매핑:
 *    - char는 문자뿐만 아니라 해당하는 유니코드 정수값(예: 'A' = 65)을 직접 할당받아 문자 형태로 다룰 수도 있습니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 01 Day 2 학습 예제 ===\n");

        System.out.println("--- Lab1: 변수 선언과 값 대입 ---");
        Lab1.run();
        System.out.println("\n[해설] 변수 선언 시 '자료형 변수명 = 값;' 형식을 사용합니다.\n");

        System.out.println("--- Lab2: 정수형 (int, long) 및 오버플로우 ---");
        Lab2.run();
        System.out.println("\n[해설] 기본 정수는 int를 사용하지만, 범위를 초과할 시 오버플로우가 나며, 대용량 정수는 long(L 접미사)을 씁니다.\n");

        System.out.println("--- Lab3: 실수 정밀도 차이 (double vs float) ---");
        Lab3.run();
        System.out.println("\n[해설] double은 float보다 두 배 가량 더 세밀하게 소수점 이하 자리(정밀도)를 유실 없이 표현합니다.\n");

        System.out.println("--- Lab4: 문자형 (char)의 문자 대입 vs 숫자 대입 ---");
        Lab4.run();
        System.out.println("\n[해설] char 변수에 아스키/유니코드 번호(65)를 넣어도 문자 'A'로 자동 변환되어 매핑 출력됩니다.\n");

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
            // int 오버플로우 체험
            int maxInt = 2147483647; // int가 가질 수 있는 최대값
            int overflowed = maxInt + 1; // 최대값에 1을 더함
            System.out.println("int 최대값: " + maxInt);
            System.out.println("최대값 + 1 (오버플로우): " + overflowed); // 최솟값으로 순환됨

            long num2 = 1000000000000L; // 1조 (long 접미사 필수)
            System.out.println("long (1조): " + num2);
        }
    }

    static class Lab3 {
        static void run() {
            double piDouble = 3.141592653589793;
            float piFloat = 3.141592653589793f; // f 접미사 필수
            System.out.println("double 정밀도: " + piDouble); // 원본 그대로 소수점 다량 출력
            System.out.println("float 정밀도: " + piFloat); // 중간에 정밀도가 깨지거나 잘림
        }
    }

    static class Lab4 {
        static void run() {
            char grade1 = 'A';
            char grade2 = 65; // 문자 'A'의 아스키 정수값
            System.out.println("문자로 넣은 char: " + grade1); // A
            System.out.println("정수로 넣은 char: " + grade2); // A
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
