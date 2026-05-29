package week02.day4;

/*
 * [정답 + 해설 4] Week 02 Day 4
 * 문제: 1~20 출력 (3의 배수 제외)
 */
public class Answer4 {
    public static void main(String[] args) {
        // continue 문은 반복문 블록 내에서 나머지 코드를 실행하지 않고, 즉시 다음 반복(조건식이나 증감식)으로 건너뛰게 합니다.
        // 예시처럼 3의 배수를 제외하고 출력하고 싶을 때 효과적으로 사용할 수 있습니다.
        for (int i = 1; i <= 20; i++) {
            if (i % 3 == 0) {
                continue; // 3의 배수면 아래 코드를 건너뛰고 증감식(i++)으로 이동
            }
            System.out.print(i + " ");
        }
    }
}
/*
 * [해설]
 * - continue 문은 현재 반복을 중단하고 다음 반복으로 즉시 넘어갑니다.
 * - 특정 조건을 제외하고 작업을 수행할 때 편리합니다.
 */
