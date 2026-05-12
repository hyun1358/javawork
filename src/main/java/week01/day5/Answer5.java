package week01.day5;

import java.util.Scanner;

/**
 * [정답 + 해설 5] Week 01 Day 5
 */
public class Answer5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("나이: ");
        int age = sc.nextInt();

        sc.nextLine(); // 버퍼 비우기 (엔터 키 제거)

        System.out.print("한마디: ");
        String msg = sc.nextLine();

        System.out.println("나이: " + age);
        System.out.println("메시지: " + msg);
        sc.close();
    }
}
/*
 [해설]
 nextInt()는 숫자만 읽고 엔터(\n)를 버퍼에 남겨둡니다. 
 뒤따라오는 nextLine()이 이 엔터를 읽어버려 입력이 종료되는 것을 막기 위해
 중간에 빈 nextLine()을 호출하여 버퍼를 비워줘야 합니다.
*/
