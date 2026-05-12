package week01.day5;

import java.util.Scanner;

/**
 * [정답 + 해설 1] Week 01 Day 5
 */
public class Answer1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름 입력: ");
        String name = sc.nextLine();
        System.out.println("안녕하세요, " + name + "님!");
        sc.close();
    }
}
/*
 [해설]
 Scanner 객체를 생성하고 nextLine()을 사용하여 문자열을 입력받습니다.
*/
