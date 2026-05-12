package week02.day3;

import java.util.Scanner;

/*
 * [정답 + 해설 5] Week 02 Day 3
 * 문제: 1~N 사이 소수 개수 구하기
 */
public class Answer5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N을 입력하세요: ");
        int n = sc.nextInt();

        int count = 0;
        for (int i = 2; i <= n; i++) { // 2부터 n까지의 각 숫자가 소수인지 확인
            boolean isPrime = true;

            for (int j = 2; j < i; j++) { // i를 2부터 i-1까지의 수로 나눠봄
                if (i % j == 0) {
                    isPrime = false; // 나누어떨어지면 소수가 아님
                    break; // 더 이상 검사할 필요 없음
                }
            }

            if (isPrime) {
                count++;
            }
        }

        System.out.println("1부터 " + n + " 사이의 소수 개수: " + count);
        sc.close();
    }
}
/*
 * [해설]
 * - 소수 판별은 '1과 자기 자신 외에 약수가 있는가'를 체크하는 것입니다.
 * - 안쪽 for 문에서 하나라도 나누어떨어지는 수가 발견되면 isPrime을 false로 바꿉니다.
 * - break를 사용하면 소수가 아님이 밝혀졌을 때 즉시 안쪽 반복문을 중단할 수 있어 효율적입니다.
 */
