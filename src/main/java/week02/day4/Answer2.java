package week02.day4;

import java.util.Scanner;

/*
 * [정답 + 해설 2] Week 02 Day 4
 * 문제: 숫자 맞추기 (정답 맞출 때까지 반복)
 */
public class Answer2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 7;
        int input = 0;

        while (input != answer) {
            System.out.print("숫자를 입력하세요: ");
            input = sc.nextInt();

            if (input != answer) {
                System.out.println("틀렸습니다. 다시 시도하세요.");
            }
        }

        System.out.println("정답입니다!");
        sc.close();
    }
}
/*
 * [해설]
 * - 'input이 answer와 같지 않은 동안' 계속 반복하도록 조건을 설정합니다.
 * - input == answer 가 되는 순간 while 문을 빠져나오게 됩니다.
 */
