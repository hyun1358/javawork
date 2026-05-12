package week02.day1;

import java.util.Scanner;

/**
 * [연습 문제 5] Week 02 Day 1
 * <p>
 * 문제: 세 개의 정수를 입력받아 그 중 가장 큰 수를 찾아 출력하세요.
 * <p>
 * 난이도: ★★★☆☆
 * 힌트: 중첩 if 문을 사용하거나 논리 연산자(&&)를 활용해보세요.
 */
public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 숫자: ");
        int n1 = sc.nextInt();
        System.out.print("두 번째 숫자: ");
        int n2 = sc.nextInt();
        System.out.print("세 번째 숫자: ");
        int n3 = sc.nextInt();

        // TODO: 세 수 중 최대값 찾기 로직 작성

        sc.close();
    }
}
