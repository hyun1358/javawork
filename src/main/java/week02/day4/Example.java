package week02.day4;

import java.util.Scanner;

/**
 * [학습 예제] Week 02 Day 4 — while / do-while 반복문 및 루프 제어 (break/continue)
 * 
 * [학습 핵심 이론: 조건에 따라 유연하게 반복하는 while 루프]
 * 1. while문:
 *    - 반복 횟수를 예측하기 어렵고, 특정 조건이 true로 유지되는 동안 무한히 반복할 때 사용합니다.
 *    - 루프 진입 전 조건식을 먼저 검사하므로, 조건이 처음부터 false이면 내부 코드가 단 한 번도 실행되지 않습니다.
 * 
 * 2. do-while문:
 *    - 일단 루프 바디 코드를 최소 1회 무조건 실행한 뒤, 하단에서 조건식을 검사하여 다음 반복 여부를 판단합니다.
 *    - 사용자 입력 유효성 검사 등 "최소 한 번은 실행해야 하는" 로직에 탁월합니다.
 * 
 * 3. 무한 루프(Infinite Loop) 방지:
 *    - while(true) 구문 사용 시 내부에서 반드시 특정 조건을 충족하면 루프를 탈출시키는 break 장치가 존재해야 메모리 고갈을 방지할 수 있습니다.
 * 
 * 4. 반복문 제어 키워드 (break와 continue):
 *    - **break**: 자신이 속한 가장 가까운 반복문 전체를 즉시 중단하고 블록을 탈출합니다.
 *    - **continue**: 반복문의 남은 하위 코드를 건너뛰고, 즉시 다음 반복 회차(for의 증감식 또는 while의 조건식)로 점프합니다.
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
