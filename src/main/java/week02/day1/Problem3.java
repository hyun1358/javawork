package week02.day1;

import java.util.Scanner;

/**
 * [연습 문제 3] Week 02 Day 1
 * <p>
 * 문제: 점수를 입력받아 다음과 같이 학점을 출력하세요.
 * 90점 이상: A
 * 80점 이상: B
 * 70점 이상: C
 * 60점 이상: D
 * 60점 미만: F
 * <p>
 * 난이도: ★★☆☆☆
 */
public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("점수를 입력하세요: ");
        int score = sc.nextInt();

        // TODO: 학점 분류 로직 작성

        sc.close();
    }
}
