package week02.day2;

import java.util.Scanner;

/*
 * [정답 + 해설 3] Week 02 Day 2
 * 문제: 메뉴 번호 -> 가격 출력
 */
public class Answer3 {
    public static void main(String[] args) {
        // if-else if 구조보다 조건 변수가 명확하게 값과 1:1 매칭될 때 switch 문을 쓰는 것이 효율적입니다.
        // 메뉴 선택과 같은 경우 switch-case가 가독성이 좋습니다.
        Scanner sc = new Scanner(System.in);
        System.out.println("1.김밥  2.라면  3.떡볶이");
        System.out.print("메뉴 선택: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("가격은 3000원입니다.");
                break;
            case 2:
                System.out.println("가격은 4000원입니다.");
                break;
            case 3:
                System.out.println("가격은 3500원입니다.");
                break;
            default:
                System.out.println("메뉴에 없습니다.");
        }

        sc.close();
    }
}
/*
 * [해설]
 * - 간단한 번호 선택 메뉴에는 switch 문이 가장 가독성이 좋습니다.
 */
