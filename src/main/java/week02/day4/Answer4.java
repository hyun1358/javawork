package week02.day4;

/*
 * [정답 + 해설 4] Week 02 Day 4
 * 문제: 1~20 출력 (3의 배수 제외)
 */
public class Answer4 {
    public static void main(String[] args) {
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
