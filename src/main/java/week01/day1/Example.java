package week01.day1;

/**
 * [학습 예제] Week 01 Day 1 — 자바 기초 출력
 * 
 * [학습 핵심 이론: 자바의 출력 스트림과 메소드]
 * 1. System 클래스:
 *    - System은 자바의 표준 입출력 및 시스템 정보를 제어하는 대표적인 클래스입니다.
 *    - 이 중 'out' 필드는 표준 출력 스트림(PrintStream 객체)을 가리킵니다.
 * 
 * 2. 출력 메소드 3대장:
 *    - print(): 데이터를 화면에 단순히 출력합니다. 개행(줄바꿈)이 일어나지 않아 연속적으로 텍스트를 나열할 때 적합합니다.
 *    - println(): 데이터를 출력한 직후 자동으로 개행(\n)을 수행하여 가독성을 높입니다.
 *    - printf(): C언어 스타일의 서식 지정자(%d, %s, %f 등)를 사용하여 정교한 텍스트 템플릿을 완성하고 출력합니다.
 * 
 * 3. Lab 학습 가이드:
 *    - Lab1: println의 개행 매커니즘 확인
 *    - Lab2: print의 연속 출력 및 println() 호출을 통한 수동 개행
 *    - Lab3: 서식 지정자(%s, %d, %n)를 활용한 템플릿 출력
 *    - Lab4: 한 줄 주석(//) 및 여러 줄 주석 의 컴파일러 처리 방식 학습
 *    - Lab5: 자바 애플리케이션의 유일한 진입점(Entry Point)인 main 메소드의 구조 이해
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
