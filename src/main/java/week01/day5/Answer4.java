package week01.day5;

import java.util.Scanner;

/**
 * [정답 + 해설 4] Week 01 Day 5
 */
public class Answer4 {
    public static void main(String[] args) {
        // nextDouble() 메서드를 호출하면 사용자로부터 실수 데이터를 입력받아 double 변수에 저장합니다.
        // 원의 넓이(반지름 * 반지름 * 3.14)와 둘레(2 * 3.14 * 반지름) 공식을 활용합니다.
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
