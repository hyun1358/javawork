package week02.day2;

import java.util.Scanner;

/*
 * [정답 + 해설 4] Week 02 Day 2
 * 문제: 학점 문자 -> 점수 범위 출력
 */
public class Answer4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("학점 입력(A~F): ");
        char grade = sc.next().toUpperCase().charAt(0);

        switch (grade) {
            case 'A':
                System.out.println("90~100점");
                break;
            case 'B':
                System.out.println("80~89점");
                break;
            case 'C':
                System.out.println("70~79점");
                break;
            case 'D':
                System.out.println("60~69점");
                break;
            case 'F':
                System.out.println("60점 미만");
                break;
            default:
                System.out.println("잘못된 학점");
        }

        sc.close();
    }
}
/*
 * [해설]
 * - switch 문은 int 뿐만 아니라 char, String 타입도 비교할 수 있습니다.
 * - 단, 소수(double)나 논리형(boolean)은 switch 문에서 사용할 수 없습니다.
 */
