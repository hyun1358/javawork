package week02.day2;

import java.util.Scanner;

/**
 * [연습 문제 3] Week 02 Day 2
 * <p>
 * 문제: 다음 메뉴 번호를 입력받아 가격을 출력하는 프로그램을 만드세요.
 * 1. 김밥 (3000원)
 * 2. 라면 (4000원)
 * 3. 떡볶이 (3500원)
 * 그 외: "메뉴에 없습니다."
 * <p>
 * 난이도: ★☆☆☆☆
 */
public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.김밥  2.라면  3.떡볶이");
        System.out.print("메뉴 선택: ");
        int choice = sc.nextInt();

        // TODO: 가격 출력 로직

        sc.close();
    }
}
