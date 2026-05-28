package week01.day4;

/**
 * [학습 예제] Week 01 Day 4 — 형변환 (Casting)과 데이터 파싱
 * 
 * [학습 핵심 이론: 데이터 타입 변환 매커니즘]
 * 1. 자동 형변환 (Implicit Casting / Promotion):
 *    - 작은 크기의 타입에서 큰 크기의 타입으로 데이터가 이동할 때 자동으로 일어납니다.
 *    - 값의 손실이 없기 때문에 컴파일러가 스스로 처리해 줍니다. (예: int -> double)
 * 
 * 2. 강제 형변환 (Explicit Casting / Demotion):
 *    - 큰 크기의 자료형에서 작은 크기의 자료형으로 강제로 변환할 때 씁니다.
 *    - 소괄호 안에 대상 자료형을 직접 지정합니다: (int) doubleValue
 *    - 변환 시 메모리 비트의 상위 바이트가 잘려 나가므로 '데이터 왜곡' 또는 '소수점 절삭' 등의 값 손실(Overflow/Truncation)이 발생합니다.
 * 
 * 3. 문자(char)와 아스키코드(ASCII/Unicode) 변환:
 *    - 자바의 char 타입은 내부적으로 2바이트 유니코드 정수로 저장됩니다.
 *    - 따라서 int형으로 변환하면 아스키/유니코드 번호(예: 'A' = 65)를 얻을 수 있고, 반대로 int형 번호에 (char)를 씌우면 문자로 복원됩니다.
 * 
 * 4. 문자열(String)과 숫자의 상호 변환:
 *    - 문자열 "100"은 텍스트일 뿐이므로 연산이 불가능합니다.
 *    - `Integer.parseInt(문자열)`을 통해 정수로 변환하여 연산할 수 있게 합니다.
 *    - 숫자를 문자열로 변환할 때는 `String.valueOf(숫자)`를 주로 사용합니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 01 Day 4 학습 예제 ===\n");

        System.out.println("--- Lab1: 자동 형변환 ---");
        Lab1.run();
        System.out.println("\n[해설] 데이터 손실이 없는 경우 자바가 알아서 바꿔줍니다.\n");

        System.out.println("--- Lab2: 강제 형변환 (Casting) ---");
        Lab2.run();
        System.out.println("\n[해설] 데이터 손실 가능성이 있을 때 (자료형)을 명시하여 강제로 바꿉니다.\n");

        System.out.println("--- Lab3: 정수 나눗셈의 함정 ---");
        Lab3.run();
        System.out.println("\n[해설] 정수/정수는 정수입니다. 실수를 얻으려면 한쪽을 실수로 바꿔야 합니다.\n");

        System.out.println("--- Lab4: 문자와 숫자의 변환 ---");
        Lab4.run();
        System.out.println("\n[해설] char는 유니코드 숫자로 관리되므로 int로 변환이 쉽습니다.\n");

        System.out.println("--- Lab5: 문자열과 숫자의 변환 ---");
        Lab5.run();
        System.out.println("\n[해설] Integer.parseInt(), String.valueOf() 등을 사용합니다.\n");
    }

    static class Lab1 {
        static void run() {
            int i = 100;
            long l = i;
            double d = l;
            System.out.println("int -> long -> double: " + d);
        }
    }

    static class Lab2 {
        static void run() {
            double d = 3.99;
            int i = (int) d; // 3으로 소수점 절삭
            System.out.println("double 3.99 -> int: " + i);
        }
    }

    static class Lab3 {
        static void run() {
            int a = 7, b = 2;
            System.out.println("7 / 2 그냥 계산: " + (a / b));
            System.out.println("7 / 2 형변환 계산: " + ((double) a / b));
        }
    }

    static class Lab4 {
        static void run() {
            char c = 'A';
            int n = c; // 자동
            System.out.println("'A' -> " + n);
            System.out.println("66 -> " + (char) 66);
        }
    }

    static class Lab5 {
        static void run() {
            String s = "100";
            int n = Integer.parseInt(s);
            String s2 = String.valueOf(n);
            System.out.println("변환된 숫자 + 200: " + (n + 200));
            System.out.println("변환된 문자열: " + s2);
        }
    }
}
