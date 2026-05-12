package week02.day2;

import java.util.Scanner;

/**
 * [연습 문제 1] Week 02 Day 2
 * <p>
 * 문제: 요일 번호(1~7)를 입력받아 요일명을 출력하세요. (1: 월요일, ..., 7: 일요일)
 * 그 외의 숫자는 "잘못된 입력"을 출력하세요.
 * <p>
 * 난이도: ★☆☆☆☆
 * 힌트: switch-case-break 구조 사용
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요일 번호(1~7): ");
        int day = sc.nextInt();

        // TODO: switch 문으로 요일 출력

        sc.close();
    }
}
