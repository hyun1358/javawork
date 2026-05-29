package week02.day1;

import java.util.Scanner;

/*
 * [정답 + 해설 4] Week 02 Day 1
 * 문제: 나이별 분류 출력
 */
public class Answer4 {
    public static void main(String[] args) {
        // 나이 구간에 따라 적절한 분류를 찾아 출력합니다.
        // 위에서부터 순서대로 조건에 부합하는지 필터링되므로, 논리적인 순서를 지키는 것이 매우 중요합니다.
        Scanner sc = new Scanner(System.in);
        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();

        if (age >= 20) {
            System.out.println("성인");
        } else if (age >= 17) {
            System.out.println("고등학생");
        } else if (age >= 14) {
            System.out.println("중학생");
        } else if (age >= 8) {
            System.out.println("초등학생");
        } else {
            System.out.println("미취학 아동");
        }

        sc.close();
    }
}
/*
 * [해설]
 * - 각 연령대별로 범위를 if-else if 구조로 나누어 출력합니다.
 */
