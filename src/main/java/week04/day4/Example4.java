package week04.day4;

/**
 * [학습 예제 4] Week 04 Day 4 — 재귀 호출(Recursion)의 원리와 활용
 * 
 * [문제별 학습 목표]
 * - Lab4: 재귀를 이용한 배열 요소 합계 구하기 (Problem 4 연계)
 */
import java.util.Arrays;

public class Example4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int arraySum = sum(arr, arr.length - 1);
        System.out.println("배열 " + Arrays.toString(arr) + "의 요소 합계: " + arraySum);
    }

    // index는 배열의 마지막 요소 위치부터 0번째 요소 위치까지 줄여나갑니다.
    public static int sum(int[] arr, int index) {
        // Base Case: 인덱스가 0일 때 첫 번째 방의 값을 반환하며 종료
        if (index == 0) {
            return arr[0];
        }
        // 현재 인덱스의 값 + (0부터 index-1까지의 누적합)
        return arr[index] + sum(arr, index - 1);
    }
}
