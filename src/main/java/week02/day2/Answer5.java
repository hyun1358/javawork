package week02.day2;

import java.util.Scanner;

/*
 * [정답 + 해설 5] Week 02 Day 2
 * 문제: switch 표현식 리팩토링
 */
public class Answer5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("학점 입력(A~F): ");
        String grade = sc.next().toUpperCase();

        // switch 표현식: 결과를 바로 변수에 대입할 수 있음
        String result = switch (grade) {
            case "A" -> "90~100점";
            case "B" -> "80~89점";
            case "C" -> "70~79점";
            case "D" -> "60~69점";
            case "F" -> "60점 미만";
            default -> "잘못된 학점";
        };

        System.out.println("결과: " + result);

        sc.close();
    }
}
/*
 * [해설]
 * - Java 14+ switch 표현식의 장점:
 *   1. 화살표(->)를 사용하여 코드가 간결해짐
 *   2. break;를 일일이 쓰지 않아도 됨
 *   3. switch 문 자체가 결과값을 반환하므로 변수에 직접 대입 가능
 */
