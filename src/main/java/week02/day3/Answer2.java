package week02.day3;

/*
 * [정답 + 해설 2] Week 02 Day 3
 * 문제: 1~100 짝수 합 구하기
 */
public class Answer2 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("1~100 짝수 합: " + sum);

        // 다른 방법 (i를 2씩 증가)
        /*
        int sum2 = 0;
        for (int i = 2; i <= 100; i += 2) {
            sum2 += i;
        }
        */
    }
}
/*
 * [해설]
 * - 1부터 100까지 돌면서 if 문으로 짝수인지 확인하고 누적합니다.
 * - 혹은 처음부터 2, 4, 6... 순서로 돌게 만들 수도 있습니다.
 */
