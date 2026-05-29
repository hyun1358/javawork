package week02.day3;

/*
 * [정답 + 해설 1] Week 02 Day 3
 * 문제: 1부터 10까지 출력
 */
public class Answer1 {
    public static void main(String[] args) {
        // for 문은 초기화, 조건식, 증감식을 한 줄에 모아두어 반복 횟수가 명확할 때 주로 사용합니다.
        // i는 1부터 시작하여 10보다 작거나 같을 때까지 계속 1씩 증가하며 반복 실행됩니다.
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
    }
}
/*
 * [해설]
 * - 초기화: int i = 1 (1부터 시작)
 * - 조건식: i <= 10 (10까지 반복)
 * - 증감식: i++ (1씩 증가)
 */
