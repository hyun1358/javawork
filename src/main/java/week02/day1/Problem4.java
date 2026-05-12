package week02.day1;

import java.util.Scanner;

/**
 * [연습 문제 4] Week 02 Day 1
 * <p>
 * 문제: 나이를 입력받아 다음 분류를 출력하세요.
 * 0~7세: 미취학 아동
 * 8~13세: 초등학생
 * 14~16세: 중학생
 * 17~19세: 고등학생
 * 20세 이상: 성인
 * <p>
 * 난이도: ★★☆☆☆
 */
public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();

        // TODO: 나이별 분류 로직 작성

        sc.close();
    }
}
