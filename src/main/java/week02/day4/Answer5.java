package week02.day4;

import java.util.Scanner;

/*
 * [정답 + 해설 5] Week 02 Day 4
 * 문제: 팩토리얼 계산 (while 활용)
 */
public class Answer5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 입력: ");
        int n = sc.nextInt();

        long factorial = 1;
        int i = n;

        while (i > 0) {
            factorial *= i;
            i--;
        }

        System.out.println(n + "! = " + factorial);
        sc.close();
    }
}
/*
 * [해설]
 * - n부터 1까지 거꾸로 내려오면서 factorial 변수에 값을 곱해나갑니다.
 */
