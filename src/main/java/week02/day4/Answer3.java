package week02.day4;

import java.util.Scanner;

/*
 * [정답 + 해설 3] Week 02 Day 4
 * 문제: 계속 여부 확인 (do-while 활용)
 */
public class Answer3 {
    public static void main(String[] args) {
        // do-while 문은 블록 내부의 코드를 무조건 최소 1번은 먼저 실행한 후, 끝에서 조건식을 검사하여 반복 여부를 결정합니다.
        // 사용자의 입력을 받아 프로그램 계속 실행 여부를 물어보는 기능에 매우 유용합니다.
        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.println("프로그램을 실행합니다...");
            System.out.print("계속하시겠습니까? (y/n): ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');

        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }
}
/*
 * [해설]
 * - do-while 문은 사용자로부터 일단 실행을 한 뒤, 계속할지 말지 결정받을 때 유용합니다.
 */
