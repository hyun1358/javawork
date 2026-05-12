package week01.day1;

/**
 * [학습 예제] Week 01 Day 1 — 자바 기초 출력
 * Lab1~Lab5를 통해 출력의 기본을 익힙니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 01 Day 1 학습 예제 ===\n");

        System.out.println("--- Lab1: println 기본 출력 ---");
        Lab1.run();
        System.out.println("\n[해설] System.out.println()은 출력 후 자동으로 줄을 바꿉니다.\n");

        System.out.println("--- Lab2: print vs println ---");
        Lab2.run();
        System.out.println("\n[해설] print()는 줄을 바꾸지 않고 이어서 출력합니다.\n");

        System.out.println("--- Lab3: printf 형식 지정 출력 ---");
        Lab3.run();
        System.out.println("\n[해설] %d(정수), %s(문자열), %f(실수) 등을 사용하여 원하는 형식을 만듭니다.\n");

        System.out.println("--- Lab4: 주석(Comment) 사용 ---");
        Lab4.run();
        System.out.println("\n[해설] 주석은 코드 실행에 영향을 주지 않으며 설명을 다는 데 사용됩니다.\n");

        System.out.println("--- Lab5: 실행 구조 확인 ---");
        Lab5.run();
        System.out.println("\n[해설] 모든 자바 프로그램은 main 메서드에서 시작됩니다.\n");
    }

    static class Lab1 {
        static void run() {
            System.out.println("자바 출력 연습 1");
            System.out.println("자바 출력 연습 2");
        }
    }

    static class Lab2 {
        static void run() {
            System.out.print("가나다");
            System.out.print("라마바");
            System.out.println(); // 줄바꿈만 수행
        }
    }

    static class Lab3 {
        static void run() {
            int count = 5;
            String item = "사과";
            System.out.printf("%s %d개가 있습니다.%n", item, count);
        }
    }

    static class Lab4 {
        static void run() {
            // 한 줄 주석
            /*
               여러 줄 주석
            */
            System.out.println("주석은 화면에 나오지 않아요.");
        }
    }

    static class Lab5 {
        static void run() {
            System.out.println("public class와 public static void main의 관계를 기억하세요.");
        }
    }
}
