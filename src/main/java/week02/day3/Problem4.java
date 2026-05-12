package week02.day3;

import java.util.Scanner;

/**
 * [연습 문제 4] Week 02 Day 3
 * <p>
 * 문제: 숫자를 하나 입력받아 해당 숫자의 구구단을 출력하세요.
 * (예: 3 입력 시 3*1=3 ... 3*9=27 출력)
 * <p>
 * 난이도: ★★☆☆☆
 */
public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("단수를 입력하세요: ");
        int dan = sc.nextInt();

        // TODO: 해당 단의 구구단 출력

        sc.close();
    }
}
