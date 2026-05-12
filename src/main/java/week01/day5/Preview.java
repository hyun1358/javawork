package week01.day5;

import java.util.Scanner;

/**
 * [예습 파일] Week 01 Day 5 — 입력받기 (Scanner)
 * <p>
 * Scanner 클래스를 사용하면 키보드로부터 데이터를 입력받을 수 있습니다.
 * 프로그램과 소통하는 방법을 미리 구경해봅시다.
 */
public class Preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();

        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();

        System.out.println("--- 입력 결과 ---");
        System.out.println("이름: " + name);
        System.out.println("나이: " + age + "살");

        sc.close(); // 사용이 끝난 Scanner는 닫아주는 것이 좋습니다.
    }
}
