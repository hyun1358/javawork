package week02.day4;

import java.util.Scanner;

/**
 * [학습 예제] Week 02 Day 4 — while / do-while
 * Lab1~Lab5를 순서대로 실행하며 각 개념을 익히세요.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 02 Day 4 학습 예제 ===\n");

        System.out.println("--- Lab1: while 기본 구조 ---");
        Lab1.run();
        System.out.println("\n[해설] while은 조건식이 true인 동안 계속 반복합니다. 블록 안에서 조건을 바꿀 증감식이 꼭 필요합니다.\n");

        System.out.println("--- Lab2: do-while 기본 구조 ---");
        Lab2.run();
        System.out.println("\n[해설] do-while은 본문을 먼저 실행한 후 조건을 검사하므로, 최소 1번은 무조건 실행됩니다.\n");

        System.out.println("--- Lab3: break 문 ---");
        Lab3.run();
        System.out.println("\n[해설] break는 반복문을 즉시 종료하고 빠져나옵니다.\n");

        System.out.println("--- Lab4: continue 문 ---");
        Lab4.run();
        System.out.println("\n[해설] continue는 아래 코드를 무시하고 다음 반복 회차로 즉시 넘어갑니다.\n");

        System.out.println("--- Lab5: 무한 루프와 탈출 ---");
        Lab5.run();
        System.out.println("\n[해설] while(true)는 의도적으로 무한 반복을 시킬 때 사용하며, 내부에 반드시 종료 조건(if+break)이 있어야 합니다.\n");
    }

    static class Lab1 {
        static void run() {
            int i = 1;
            while (i <= 3) {
                System.out.println("반복 중: " + i);
                i++;
            }
        }
    }

    static class Lab2 {
        static void run() {
            int i = 10;
            do {
                System.out.println("일단 실행! i=" + i);
            } while (i < 5);
        }
    }

    static class Lab3 {
        static void run() {
            int i = 1;
            while (i <= 10) {
                if (i == 5) {
                    System.out.println("5가 되어 중단합니다.");
                    break;
                }
                System.out.print(i + " ");
                i++;
            }
            System.out.println();
        }
    }

    static class Lab4 {
        static void run() {
            for (int i = 1; i <= 5; i++) {
                if (i == 3) {
                    System.out.println("(3은 건너뜁니다)");
                    continue;
                }
                System.out.println("숫자: " + i);
            }
        }
    }

    static class Lab5 {
        static void run() {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("0을 입력하면 종료됩니다: ");
                int input = sc.nextInt();
                if (input == 0) {
                    System.out.println("종료합니다.");
                    break;
                }
            }
        }
    }
}
