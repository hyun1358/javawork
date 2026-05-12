package week02.day2;

import java.util.Scanner;

/**
 * [연습 문제 4] Week 02 Day 2
 * <p>
 * 문제: 학점 문자(A, B, C, D, F)를 입력받아 점수 범위를 출력하세요.
 * A: 90~100점
 * B: 80~89점
 * C: 70~79점
 * D: 60~69점
 * F: 60점 미만
 * <p>
 * 난이도: ★★☆☆☆
 */
public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("학점 입력(A~F): ");
        char grade = sc.next().toUpperCase().charAt(0);

        // TODO: 학점별 점수 범위 출력

        sc.close();
    }
}
