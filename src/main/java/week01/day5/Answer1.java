package week01.day5;

import java.util.Scanner;

/**
 * [정답 + 해설 1] Week 01 Day 5
 */
public class Answer1 {
    public static void main(String[] args) {
        // Scanner 클래스는 사용자로부터 입력을 받기 위해 사용되며, System.in은 표준 입력(키보드)을 의미합니다.
        // nextLine() 메서드는 사용자가 엔터키를 누르기 전까지 입력한 한 줄 전체를 문자열(String)로 반환합니다.
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
