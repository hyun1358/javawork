package week02.day1;

import java.util.Scanner;

/*
 * [정답 + 해설 5] Week 02 Day 1
 * 문제: 세 수 중 최대값 찾기
 */
public class Answer5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 숫자: ");
        int n1 = sc.nextInt();
        System.out.print("두 번째 숫자: ");
        int n2 = sc.nextInt();
        System.out.print("세 번째 숫자: ");
        int n3 = sc.nextInt();

        int max = n1; // n1을 일단 최대값으로 가정

        if (n2 > max) {
            max = n2; // n2가 더 크면 max 교체
        }
        if (n3 > max) {
            max = n3; // n3가 더 크면 max 교체
        }

        System.out.println("가장 큰 수는 " + max + "입니다.");

        sc.close();
    }
}
/*
 * [해설]
 * - 변수 max를 하나 두고, 순서대로 비교하면서 더 큰 값이 나오면 max를 업데이트하는 방식이 깔끔합니다.
 * - if-else if가 아닌 독립적인 if 문들을 사용하는 이유를 생각해보세요.
 */
