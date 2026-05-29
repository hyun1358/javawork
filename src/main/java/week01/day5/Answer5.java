package week01.day5;

import java.util.Scanner;

/**
 * [정답 + 해설 5] Week 01 Day 5
 */
public class Answer5 {
    public static void main(String[] args) {
        // nextInt()로 숫자를 읽으면 입력 버퍼에 개행 문자(엔터)가 남아 있게 됩니다.
        // 그 직후 nextLine()을 호출하면 버퍼에 남은 엔터를 읽어버려 입력이 건너뛰어지는 현상이 발생합니다.
        // 이를 방지하기 위해 빈 nextLine()을 호출하여 입력 버퍼를 비워주는 과정이 필수적입니다.
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
