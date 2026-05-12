package week03.day1;

/*
 * [정답 + 해설 2] Week 03 Day 1
 * 문제: 배열에서 최댓값 찾기
 */
public class Answer2 {
    public static void main(String[] args) {
        int[] arr = {12, 45, 7, 23, 56, 32};
        int max = arr[0]; // 첫 번째 요소를 최댓값으로 가정

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) { // 현재 max보다 큰 값을 발견하면
                max = arr[i];   // max 교체
            }
        }

        System.out.println("최댓값: " + max);
    }
}
/*
 * [해설]
 * - '최댓값 찾기' 알고리즘의 기본: 기준값(max)을 설정하고 전체를 훑으며 비교합니다.
 * - 초기 max값은 배열의 첫 번째 값(arr[0])으로 설정하는 것이 안전합니다.
 * - if문(arr[i] > max)을 통해 현재 알고 있는 최댓값보다 더 큰 녀석을 찾으면 업데이트합니다.
 */
