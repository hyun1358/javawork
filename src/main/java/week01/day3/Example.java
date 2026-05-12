package week01.day3;

/**
 * [학습 예제] Week 01 Day 3 — 연산자
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 01 Day 3 학습 예제 ===\n");

        System.out.println("--- Lab1: 산술 연산자 (+, -, *, /, %) ---");
        Lab1.run();
        System.out.println("\n[해설] /는 몫을, %는 나머지를 구합니다. 정수끼리의 계산 결과는 정수입니다.\n");

        System.out.println("--- Lab2: 비교 연산자 (==, !=, >, <, >=, <=) ---");
        Lab2.run();
        System.out.println("\n[해설] 비교 연산의 결과는 항상 boolean(true/false)입니다.\n");

        System.out.println("--- Lab3: 논리 연산자 (&&, ||, !) ---");
        Lab3.run();
        System.out.println("\n[해설] &&(AND)는 둘 다 참일 때, ||(OR)는 하나만 참이어도 참입니다.\n");

        System.out.println("--- Lab4: 복합 대입 연산자 (+=, -=, *=, /=, %=) ---");
        Lab4.run();
        System.out.println("\n[해설] a += b는 a = a + b와 같은 의미입니다.\n");

        System.out.println("--- Lab5: 증감 연산자 (++, --) ---");
        Lab5.run();
        System.out.println("\n[해설] ++이 앞에 붙으면(전위) 증가 후 사용, 뒤에 붙으면(후위) 사용 후 증가합니다.\n");
    }

    static class Lab1 {
        static void run() {
            int x = 10, y = 3;
            System.out.println("x + y = " + (x + y));
            System.out.println("x / y = " + (x / y));
            System.out.println("x % y = " + (x % y));
        }
    }

    static class Lab2 {
        static void run() {
            int a = 10, b = 20;
            System.out.println("a == b : " + (a == b));
            System.out.println("a != b : " + (a != b));
            System.out.println("a < b  : " + (a < b));
        }
    }

    static class Lab3 {
        static void run() {
            boolean t = true, f = false;
            System.out.println("t && f : " + (t && f));
            System.out.println("t || f : " + (t || f));
            System.out.println("!t     : " + (!t));
        }
    }

    static class Lab4 {
        static void run() {
            int n = 10;
            n += 5; // n = 15
            System.out.println("n += 5 결과: " + n);
            n *= 2; // n = 30
            System.out.println("n *= 2 결과: " + n);
        }
    }

    static class Lab5 {
        static void run() {
            int i = 1;
            System.out.println("++i : " + (++i)); // 2
            System.out.println("i++ : " + (i++)); // 2 (출력 후 3이 됨)
            System.out.println("최종 i: " + i);
        }
    }
}
