package week03.day1;

import java.util.Scanner;

/*
 * [정답 + 해설 4] Week 03 Day 1
 * 문제: 배열에 특정 값이 있는지 찾기
 */
public class Answer4 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        Scanner sc = new Scanner(System.in);
        System.out.print("찾을 숫자 입력: ");
        int target = sc.nextInt();

        boolean found = false; // 발견 여부 저장용

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                found = true;
                break; // 찾았으면 더 돌지 않고 탈출
            }
        }

        if (found) {
            System.out.println(target + "은(는) 배열에 있습니다.");
        } else {
            System.out.println(target + "은(는) 배열에 없습니다.");
        }

        sc.close();
    }
}
/*
 * [해설]
 * - '순차 탐색(Sequential Search)'의 기본 원리입니다.
 * - 처음부터 끝까지 돌며 값이 일치하는지 확인합니다.
 * - found라는 변수를 사용해 '발견 여부'를 저장해두는 방식은 아주 흔히 쓰입니다.
 * - break를 사용해 불필요한 연산을 줄이는 습관도 중요합니다.
 */
