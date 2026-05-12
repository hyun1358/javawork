package week02.day3;

import java.util.Scanner;

/*
 * [정답 + 해설 4] Week 02 Day 3
 * 문제: 특정 단의 구구단 출력
 */
public class Answer4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("단수를 입력하세요: ");
        int dan = sc.nextInt();

        System.out.println("[" + dan + "단]");
        for (int i = 1; i <= 9; i++) {
            System.out.println(dan + " * " + i + " = " + (dan * i));
        }

        sc.close();
    }
}
/*
 * [해설]
 * - 입력받은 dan 값은 고정해두고, 곱해지는 수 i만 1부터 9까지 변화시킵니다.
 */
