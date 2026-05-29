package week02.day1;

import java.util.Scanner;

/*
 * [정답 + 해설 2] Week 02 Day 1
 * 문제: 양수/음수/0 판별
 */
public class Answer2 {
    public static void main(String[] args) {
        // if-else if 구조를 사용하면 여러 개의 조건을 순차적으로 검사할 수 있습니다.
        // 양수(>0), 음수(<0), 그리고 그 외의 경우(0)를 완벽하게 분기하여 처리합니다.
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
