package week01.day5;

import java.util.Scanner;

/**
 * [예습 파일] Week 01 Day 5 — 입력받기 (Scanner)
 * 
 * 지금까지는 프로그램이 우리에게 '말'을 하기만 했다면, (출력)
 * 이제는 우리가 프로그램에 '입력'을 해볼 차례입니다.
 * 
 * [Scanner 사용법]
 * 1. import java.util.Scanner; : 도구함에서 Scanner를 꺼내옵니다.
 * 2. Scanner sc = new Scanner(System.in); : 입력을 도와줄 도구(sc)를 만듭니다.
 * 3. sc.next(): 공백 전까지 문자열을 읽습니다.
 * 4. sc.nextLine(): 엔터 치기 전까지 한 줄 전체를 읽습니다.
 * 5. sc.nextInt(): 숫자를 읽습니다.
 */
public class Preview {
    public static void main(String[] args) {
        // 입력 도구 생성
        Scanner sc = new Scanner(System.in);

        System.out.print("당신의 이름을 입력하고 엔터를 누르세요: ");
        String name = sc.nextLine();

        System.out.print("당신의 나이를 입력하세요: ");
        int age = sc.nextInt();

        System.out.println("\n--- 입력 결과 확인 ---");
        System.out.println("반갑습니다, " + name + "님!");
        System.out.println("내년이면 " + (age + 1) + "살이 되시는군요!");

        // 사용이 끝난 도구는 닫아주는 것이 매너입니다.
        sc.close(); 
    }
}
