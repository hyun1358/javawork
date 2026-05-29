package week01.day5;

import java.util.Scanner;

/**
 * [정답 + 해설 3] Week 01 Day 5
 */
public class Answer3 {
    public static void main(String[] args) {
        // Scanner를 사용하여 이름과 나이를 각각 입력받은 뒤, 
        // 변수 age에 1을 더해 산술 연산 결과와 문자열을 결합하여 출력합니다.
        Scanner sc = new Scanner(System.in);
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("나이: ");
        int age = sc.nextInt();

        System.out.println(name + "님, 내년에는 " + (age + 1) + "살이 되시겠네요!");
        sc.close();
    }
}
/*
 [해설]
 입력받은 나이에 1을 더해 내년 나이를 계산합니다.
*/
