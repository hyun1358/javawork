package week02.day2;

import java.util.Scanner;

/*
 * [정답 + 해설 1] Week 02 Day 2
 * 문제: 요일 번호 -> 요일명 출력
 */
public class Answer1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요일 번호(1~7): ");
        int day = sc.nextInt();

        switch (day) {
            case 1:
                System.out.println("월요일");
                break;
            case 2:
                System.out.println("화요일");
                break;
            case 3:
                System.out.println("수요일");
                break;
            case 4:
                System.out.println("목요일");
                break;
            case 5:
                System.out.println("금요일");
                break;
            case 6:
                System.out.println("토요일");
                break;
            case 7:
                System.out.println("일요일");
                break;
            default:
                System.out.println("잘못된 입력");
        }

        sc.close();
    }
}
/*
 * [해설]
 * - switch 문은 변수의 값에 따라 해당 case로 직접 점프합니다.
 * - 각 case의 끝에는 반드시 break;를 써야 다음 case까지 실행되지 않습니다.
 */
