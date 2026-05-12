package week01.day5;

import java.util.Scanner;

/**
 * [정답 + 해설 4] Week 01 Day 5
 */
public class Answer4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("반지름 입력: ");
        double r = sc.nextDouble();

        System.out.println("넓이: " + (r * r * 3.14));
        System.out.println("둘레: " + (2 * 3.14 * r));
        sc.close();
    }
}
/*
 [해설]
 실수 입력은 nextDouble()을 사용합니다.
*/
