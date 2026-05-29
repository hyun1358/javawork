package week03.day1;

/*
 * [정답 + 해설 5] Week 03 Day 1
 * 문제: 배열 원소 중 짝수만 출력
 */
public class Answer5 {
    // 메인 메서드: 배열 요소 중에서 짝수만 선별하여 출력
    public static void main(String[] args) {
        // 다양한 정수가 포함된 배열 초기화
        int[] arr = {10, 15, 20, 25, 30, 35, 40};

        // 1. 전체 배열을 돌며 2로 나눴을 때 나머지가 0인 녀석만 출력합니다.
        // 배열 전체를 순회하기 위한 반복문
        for (int i = 0; i < arr.length; i++) {
            // 현재 배열의 요소가 2로 나누어 떨어지는지(짝수인지) 확인
            if (arr[i] % 2 == 0) {
                // 짝수 조건을 만족하는 요소만 한 줄에 공백을 두고 출력
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
