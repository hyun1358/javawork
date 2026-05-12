package week02.day5;

import java.util.Scanner;

public class Answer5 {
    public static void main(String[] args) {
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
