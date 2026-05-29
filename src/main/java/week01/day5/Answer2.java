package week01.day5;

import java.util.Scanner;

/**
 * [정답 + 해설 2] Week 01 Day 5
 */
public class Answer2 {
    public static void main(String[] args) {
        // nextInt() 메서드는 사용자가 입력한 내용을 정수(int) 형태로 변환하여 반환합니다.
        // 만약 숫자 이외의 문자를 입력하면 예외(InputMismatchException)가 발생할 수 있습니다.
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
