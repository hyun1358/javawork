package week03.day1;

import java.util.Scanner;

/**
 * [연습 문제 4] Week 03 Day 1
 * <p>
 * 문제: 숫자를 하나 입력받아 배열에 그 숫자가 있는지 확인하세요.
 * 배열: {10, 20, 30, 40, 50}
 * 있으면: "[숫자]은(는) 배열에 있습니다." 출력
 * 없으면: "[숫자]은(는) 배열에 없습니다." 출력
 * <p>
 * 난이도: ★★☆☆☆
 * 힌트: boolean 변수를 활용해 발견 여부를 저장하세요.
 */
public class Problem4 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        Scanner sc = new Scanner(System.in);
        System.out.print("찾을 숫자 입력: ");
        int target = sc.nextInt();

        // TODO: 배열에 target이 있는지 확인하는 코드를 작성하세요

        sc.close();
    }
}
