package week02.day1;

import java.util.Scanner;

/**
 * [예습 파일] Week 02 Day 1 — 조건문 if / else if / else
 * <p>
 * ▶ 이 파일을 먼저 실행해보세요!
 * 오늘 배울 내용을 코드로 미리 구경할 수 있습니다.
 * 조건에 따라 프로그램의 흐름이 어떻게 바뀌는지 확인해보세요.
 */
public class Preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 오늘 배울 내용 미리보기 ===");

        // 1. 간단한 if 문 (나이 체크)
        int age = 20;
        if (age >= 19) {
            System.out.println("성인입니다.");
        }

        // 2. if-else 문 (홀수/짝수 판별)
        int num = 7;
        if (num % 2 == 0) {
            System.out.println("짝수입니다.");
        } else {
            System.out.println("홀수입니다.");
        }

        // 3. else if 문 (점수 학점 분류)
        int score = 85;
        if (score >= 90) {
            System.out.println("A 학점");
        } else if (score >= 80) {
            System.out.println("B 학점");
        } else {
            System.out.println("C 학점 이하");
        }

        System.out.println("--- 미리보기 끝 ---");
        sc.close();
    }
}
