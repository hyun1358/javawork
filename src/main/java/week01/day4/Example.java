package week01.day4;

/**
 * [학습 예제] Week 01 Day 4 — 형변환
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
            double d = 3.9;
            int i = (int) d; // 3으로 소수점 절삭
            System.out.println("double 3.9 -> int: " + i);
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
            String s = "10";
            int n = Integer.parseInt(s);
            String s2 = String.valueOf(n);
            System.out.println("변환된 숫자 + 1: " + (n + 1));
            System.out.println("변환된 문자열: " + s2);
        }
    }
}
