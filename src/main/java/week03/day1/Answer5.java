package week03.day1;

/*
 * [정답 + 해설 5] Week 03 Day 1
 * 문제: 배열 원소 중 짝수만 출력
 */
public class Answer5 {
    public static void main(String[] args) {
        int[] arr = {10, 15, 20, 25, 30, 35, 40};

        // 1. 전체 배열을 돌며 2로 나눴을 때 나머지가 0인 녀석만 출력합니다.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
/*
 * [해설]
 * - 배열 순회(Traversal)와 조건문(Condition)을 조합하는 기본 문제입니다.
 * - if문(arr[i] % 2 == 0)을 통해 짝수인지 판별합니다.
 */
