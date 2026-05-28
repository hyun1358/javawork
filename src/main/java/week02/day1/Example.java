package week02.day1;

/**
 * [학습 예제] Week 02 Day 1 — IF 조건문 기초
 * 
 * [학습 핵심 이론: 분기 처리를 위한 if 제어문]
 * 1. 단일 if문:
 *    - 조건식의 결과가 true일 때만 내부 블록의 코드를 실행하고, false이면 건너뜁니다.
 * 
 * 2. if-else문:
 *    - 조건식이 true일 때와 false일 때 실행할 코드 블록을 확실하게 양자택일로 나눕니다.
 * 
 * 3. 다중 if-else if-else문:
 *    - 여러 개의 독립된 조건들을 위에서부터 차례로 검사하여 참이 되는 첫 번째 블록만 실행하고 전체 조건문을 탈출합니다.
 *    - 모든 조건이 만족하지 않을 때의 기본 실행 블록은 마지막 else 블록에 정의합니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 02 Day 1 학습 예제 ===\n");

        System.out.println("--- Lab1: 기본 if 문 ---");
        Lab1.run();
        System.out.println("\n[해설] if 문은 조건식이 true일 때만 내부 블록을 실행합니다.\n");

        System.out.println("--- Lab2: if-else 문 ---");
        Lab2.run();
        System.out.println("\n[해설] if-else는 조건이 true면 if 블록을, false면 else 블록을 실행합니다.\n");

        System.out.println("--- Lab3: else if 문 ---");
        Lab3.run();
        System.out.println("\n[해설] else if를 사용하면 여러 개의 조건을 순차적으로 검사할 수 있습니다.\n");

        System.out.println("--- Lab4: 중첩 if 문 ---");
        Lab4.run();
        System.out.println("\n[해설] if 문 안에 또 다른 if 문을 넣을 수 있습니다. 상세한 분류가 가능합니다.\n");

        System.out.println("--- Lab5: 조건식 단순화 ---");
        Lab5.run();
        System.out.println("\n[해설] boolean 타입 변수는 '== true' 없이 변수명 자체로 조건식에 쓸 수 있습니다.\n");
    }

    static class Lab1 {
        static void run() {
            int score = 80;
            if (score >= 60) {
                System.out.println("합격입니다!");
            }
        }
    }

    static class Lab2 {
        static void run() {
            int num = -5;
            if (num >= 0) {
                System.out.println("양수 또는 0입니다.");
            } else {
                System.out.println("음수입니다.");
            }
        }
    }

    static class Lab3 {
        static void run() {
            int age = 15;
            if (age >= 19) {
                System.out.println("성인");
            } else if (age >= 13) {
                System.out.println("청소년");
            } else {
                System.out.println("어린이");
            }
        }
    }

    static class Lab4 {
        static void run() {
            int score = 95;
            if (score >= 90) {
                if (score >= 95) {
                    System.out.println("A+ 학점입니다.");
                } else {
                    System.out.println("A0 학점입니다.");
                }
            }
        }
    }

    static class Lab5 {
        static void run() {
            boolean isRainy = true;
            // if (isRainy == true) 보다는 아래 형식이 권장됩니다.
            if (isRainy) {
                System.out.println("우산을 챙기세요.");
            }
        }
    }
}
