package week02.day6;

import java.util.Scanner;

/**
 * [미니 프로젝트 정답] Week 02 Day 6 — 콘솔 메뉴 시스템
 */
public class MiniProjectAnswer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("\n--- 메뉴 선택 ---");
            System.out.println("1. 간단 계산기(합)");
            System.out.println("2. 구구단 출력");
            System.out.println("3. 별 삼각형 출력");
            System.out.println("4. 종료");
            System.out.print("선택> ");

            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.print("첫 번째 수: ");
                    int num1 = sc.nextInt();
                    System.out.print("두 번째 수: ");
                    int num2 = sc.nextInt();
                    System.out.println("합계: " + (num1 + num2));
                    break;
                case 2:
                    System.out.print("몇 단을 출력할까요?: ");
                    int dan = sc.nextInt();
                    for (int i = 1; i <= 9; i++) {
                        System.out.printf("%d * %d = %d\n", dan, i, dan * i);
                    }
                    break;
                case 3:
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    run = false;
                    break;
                default:
                    System.out.println("잘못된 메뉴 번호입니다.");
            }
        }
        sc.close();
    }
}
