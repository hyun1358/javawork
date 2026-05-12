package week02.day1;

import java.util.Scanner;

/*
 * [정답 + 해설 2] Week 02 Day 1
 * 문제: 양수/음수/0 판별
 */
public class Answer2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하세요: ");
        int num = sc.nextInt();

        if (num > 0) {
            System.out.println("양수입니다.");
        } else if (num < 0) {
            System.out.println("음수입니다.");
        } else {
            System.out.println("0입니다.");
        }

        sc.close();
    }
}
/*
 * [해설]
 * - else if는 이전의 if 조건이 false일 때 새로운 조건을 검사합니다.
 * - 세 가지 이상의 경우를 나눌 때 유용합니다.
 */
