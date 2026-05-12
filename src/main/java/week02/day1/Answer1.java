package week02.day1;

import java.util.Scanner;

/*
 * [정답 + 해설 1] Week 02 Day 1
 * 문제: 점수 입력 -> 합격/불합격 판별
 */
public class Answer1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("점수를 입력하세요: ");
        int score = sc.nextInt();

        if (score >= 60) {
            System.out.println("합격");
        } else {
            System.out.println("불합격");
        }

        sc.close();
    }
}
/*
 * [해설]
 * - score >= 60 이 참(true)이면 if 블록을 실행하여 "합격"을 출력합니다.
 * - 거짓(false)이면 else 블록을 실행하여 "불합격"을 출력합니다.
 */
