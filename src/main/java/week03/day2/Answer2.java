package week03.day2;

import java.util.Arrays;

/*
 * [정답 + 해설 2] Week 03 Day 2
 * 문제: 버블 정렬 직접 구현
 */
public class Answer2 {
    // 메인 메서드: 버블 정렬 알고리즘 직접 구현
    public static void main(String[] args) {
        // 정렬할 정수 배열 초기화
        int[] arr = {15, 7, 22, 1, 9};

        // 버블 정렬 구현
        // 바깥쪽 반복문: 전체 배열을 순회 (마지막 요소는 자동 정렬되므로 length - 1)
        for (int i = 0; i < arr.length - 1; i++) {
            // 안쪽 반복문: 인접한 요소를 비교, i번 반복될 때마다 가장 큰 수가 맨 뒤로 이동
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 인접한 두 값을 비교하여 앞의 값이 더 크면 교체 (오름차순)
                if (arr[j] > arr[j + 1]) {
                    // 두 값을 교환하기 위해 임시 변수 temp 사용
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // 정렬이 완료된 배열을 문자열로 변환하여 출력
        System.out.println("정렬 결과: " + Arrays.toString(arr));
    }
}
/*
 * [해설]
 * - 버블 정렬은 가장 큰 값을 맨 뒤로 하나씩 보내는 방식입니다.
 * - 바깥쪽 루프(i)가 돌 때마다 정렬이 완료된 맨 뒤의 요소를 제외하고 비교합니다.
 * - '교체(Swap)' 작업에는 임시 변수(temp)가 반드시 필요합니다.
 */
