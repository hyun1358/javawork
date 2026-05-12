package week04.day6;

import java.util.Scanner;

/**
 * [미니 프로젝트 정답] Week 04 Day 6 — 학생 성적 관리 시스템 (메서드 버전)
 */
public class MiniProjectAnswer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = null;
        boolean run = true;

        while (run) {
            displayMenu();
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("학생 수 입력: ");
                    int count = sc.nextInt();
                    scores = new int[count];
                    for (int i = 0; i < count; i++) {
                        scores[i] = inputScore(sc, i + 1);
                    }
                    break;
                case 2:
                    if (scores == null) {
                        System.out.println("데이터가 없습니다. 먼저 입력해주세요.");
                    } else {
                        printScores(scores);
                    }
                    break;
                case 3:
                    if (scores == null) {
                        System.out.println("데이터가 없습니다.");
                    } else {
                        System.out.println("평균 점수: " + calculateAverage(scores));
                        System.out.println("최고 점수: " + findMax(scores));
                    }
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    run = false;
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
        sc.close();
    }

    public static void displayMenu() {
        System.out.println("\n--- 성적 관리 시스템 ---");
        System.out.println("1. 점수 입력");
        System.out.println("2. 점수 리스트");
        System.out.println("3. 분석 (평균/최고)");
        System.out.println("4. 종료");
        System.out.print("선택> ");
    }

    public static int inputScore(Scanner sc, int studentNum) {
        System.out.printf("%d번 학생 점수: ", studentNum);
        return sc.nextInt();
    }

    public static void printScores(int[] scores) {
        System.out.println("--- 점수 리스트 ---");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d번 학생: %d점\n", i + 1, scores[i]);
        }
    }

    public static double calculateAverage(int[] scores) {
        int sum = 0;
        for (int s : scores) sum += s;
        return (double) sum / scores.length;
    }

    public static int findMax(int[] scores) {
        int max = scores[0];
        for (int s : scores) {
            if (s > max) max = s;
        }
        return max;
    }
}
