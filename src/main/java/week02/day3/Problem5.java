package week02.day3;

import java.util.Scanner;

/**
 * [연습 문제 5] Week 02 Day 3
 * <p>
 * 문제: 숫자 N을 입력받아 1부터 N 사이의 소수(Prime Number)가 몇 개인지 구하세요.
 * (소수: 1과 자기 자신만으로 나누어떨어지는 수, 1은 제외)
 * <p>
 * 난이도: ★★★★☆
 * 힌트: 중첩 for 문을 사용하세요.
 * 바깥 for 문은 2부터 N까지 숫자를 하나씩 고르고,
 * 안쪽 for 문은 그 숫자가 소수인지 판별합니다.
 */
public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N을 입력하세요: ");
        int n = sc.nextInt();

        int count = 0;
        // TODO: 소수 개수 세기 로직 작성

        System.out.println("1부터 " + n + " 사이의 소수 개수: " + count);
        sc.close();
    }
}
