package week02.day2;

import java.util.Scanner;

/**
 * [연습 문제 2] Week 02 Day 2
 * <p>
 * 문제: 월(1~12)을 입력받아 계절을 출력하세요.
 * 3, 4, 5월: 봄
 * 6, 7, 8월: 여름
 * 9, 10, 11월: 가을
 * 12, 1, 2월: 겨울
 * <p>
 * 난이도: ★★☆☆☆
 * 힌트: 여러 case를 break 없이 나열하여 묶어보세요.
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("월을 입력하세요(1~12): ");
        int month = sc.nextInt();

        // TODO: 계절 출력 로직 작성

        sc.close();
    }
}
