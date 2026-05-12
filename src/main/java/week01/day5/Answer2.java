package week01.day5;

import java.util.Scanner;

/**
 * [정답 + 해설 2] Week 01 Day 5
 */
public class Answer2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 정수: ");
        int n1 = sc.nextInt();
        System.out.print("두 번째 정수: ");
        int n2 = sc.nextInt();

        System.out.println("합: " + (n1 + n2));
        System.out.println("차: " + (n1 - n2));
        System.out.println("곱: " + (n1 * n2));
        sc.close();
    }
}
/*
 [해설]
 정수를 입력받을 때는 nextInt()를 사용합니다.
*/
