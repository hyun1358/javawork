package week01.day6;

import java.util.Scanner;

/**
 * [미니 프로젝트 정답] Week 01 Day 6 — 나만의 명함 출력기
 */
public class MiniProjectAnswer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 명함 정보를 입력해주세요 ===");
        System.out.print("이름: ");
        String name = sc.nextLine();

        System.out.print("나이: ");
        int age = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        System.out.print("이메일: ");
        String email = sc.nextLine();

        System.out.print("한마디: ");
        String message = sc.nextLine();

        System.out.println("\n=============================");
        System.out.printf("      %s의 명함\n", name);
        System.out.println("=============================");
        System.out.printf(" 이름  : %s\n", name);
        System.out.printf(" 나이  : %d살\n", age);
        System.out.printf(" 이메일: %s\n", email);
        System.out.printf(" 한마디: \"%s\"\n", message);
        System.out.println("=============================");

        sc.close();
    }
}
