package week02.day4;

import java.util.Scanner;

/**
 * [연습 문제 5] Week 02 Day 4
 * <p>
 * 문제: 숫자 N을 입력받아 N! (팩토리얼) 값을 while 문으로 계산하여 출력하세요.
 * (예: 5! = 5 * 4 * 3 * 2 * 1 = 120)
 * <p>
 * 난이도: ★★★☆☆
 */
public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 입력: ");
        int n = sc.nextInt();

        long factorial = 1;
        // TODO: while 문으로 팩토리얼 계산

        System.out.println(n + "! = " + factorial);
        sc.close();
    }
}
