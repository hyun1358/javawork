package week02.day2;

import java.util.Scanner;

/**
 * [연습 문제 5] Week 02 Day 2
 * <p>
 * 문제: [연습 문제 4]를 Java 14의 'switch 표현식(->)'을 사용하여 리팩토링하세요.
 * 결과 문자열을 변수에 담아 마지막에 한 번만 출력하세요.
 * <p>
 * 난이도: ★★★☆☆
 */
public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("학점 입력(A~F): ");
        String grade = sc.next().toUpperCase();

        // TODO: switch 표현식을 사용하여 결과 문자열 변수에 대입

        // System.out.println("결과: " + result);

        sc.close();
    }
}
