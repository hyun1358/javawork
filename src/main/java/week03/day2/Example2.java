package week03.day2;

/**
 * [학습 예제 2] Week 03 Day 2 — 배열 정렬 및 응용
 * 
 * [학습 핵심 이론: 배열 조작 및 알고리즘 기초]
 * 2. 버블 정렬(Bubble Sort):
 *    - 가장 인접한 두 요소를 비교하며 위치를 교환(Swap)해 나가는 단순 정렬 알고리즘입니다.
 *    - 시간 복잡도는 O(N^2)이며, 직관적인 반복 루프 처리를 연습하기에 훌륭합니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: 버블 정렬 직접 구현 (Problem 2 연계)
 */
import java.util.Arrays;

public class Example2 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab2: 버블 정렬 직접 구현 (Problem 2 연계) ---");
        Lab2.run();
    }

    static class Lab2 {
        static void run() {
            int[] arr = {15, 7, 22, 1, 9};
            // 버블 정렬 구현
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // Swap
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
            System.out.println("직접 구현한 버블 정렬 결과: " + Arrays.toString(arr));
        }
    }
}
