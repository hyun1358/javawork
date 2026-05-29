package week02.day3;

import java.util.Scanner;

/*
 * [정답 + 해설 4] Week 02 Day 3
 * 문제: 특정 단의 구구단 출력
 */
public class Answer4 {
    public static void main(String[] args) {
        // 사용자로부터 단수(dan)를 입력받고, for 문을 1부터 9까지 돌리며 해당 단의 구구단을 출력합니다.
        // dan 변수는 고정값으로 유지되고, 반복문 제어 변수인 i가 1씩 증가하며 곱셈이 이루어집니다.
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
