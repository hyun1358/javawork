package week02.day5;

import java.util.Scanner;

public class Answer5 {
    public static void main(String[] args) {
        // while(true)를 이용해 무한 루프를 생성하여 사용자 메뉴를 계속 띄웁니다.
        // 종료 조건(choice == 3)일 때 break를 호출하여 무한 루프를 빠져나가는 전형적인 콘솔 프로그램 구조입니다.
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("1.인사 2.시간 3.종료 : ");
            int choice = sc.nextInt();
            if (choice == 3) break;

            switch (choice) {
                case 1 -> System.out.println("반가워요!");
                case 2 -> System.out.println("지금은 열공 시간!");
                default -> System.out.println("잘못된 입력");
            }
        }
        sc.close();
    }
}
