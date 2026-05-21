package week02.day1;

import java.util.Scanner;

/**
 * [예습 파일] Week 02 Day 1 — 조건문 (if / else if / else)
 * 
 * 조건문은 프로그램에 '지능'을 주는 것과 같습니다.
 * "만약 ~라면 A를 하고, 아니면 B를 해라!"라고 판단 기준을 세워줍니다.
 * 
 * [조건문의 종류]
 * 1. if (조건식): '조건식'이 참(true)일 때만 실행합니다.
 * 2. else: 앞의 if 조건이 거짓(false)일 때 무조건 실행합니다.
 * 3. else if (조건식): 앞의 조건이 거짓일 때, 또 다른 새로운 조건을 검사합니다.
 */
public class Preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 자바 판단 프로그램 ===");

        // 1. 간단한 if 문 (나이 체크)
        int age = 20;
        if (age >= 19) {
            System.out.println("1. 당신은 성인입니다.");
        }

        // 2. if-else 문 (홀수/짝수 판별)
        int num = 7;
        if (num % 2 == 0) {
            System.out.println("2. " + num + "은(는) 짝수입니다.");
        } else {
            System.out.println("2. " + num + "은(는) 홀수입니다.");
        }

        // 3. else if 문 (점수 학점 분류)
        int score = 85;
        System.out.print("3. 결과: ");
        if (score >= 90) {
            System.out.println("A 학점 (축하합니다!)");
        } else if (score >= 80) {
            System.out.println("B 학점 (잘하셨어요!)");
        } else {
            System.out.println("C 학점 이하 (분발하세요!)");
        }

        System.out.println("\n--- 판단 종료 ---");
        sc.close();
    }
}
