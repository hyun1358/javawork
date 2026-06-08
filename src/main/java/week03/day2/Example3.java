package week03.day2;

/**
 * [학습 예제 3] Week 03 Day 2 — 배열 정렬 및 응용
 * 
 * [학습 핵심 이론: 배열 조작 및 알고리즘 기초]
 * 3. 배열 병합(Merge):
 *    - 두 배열의 데이터를 하나의 큰 배열로 합치는 기법입니다.
 *    - 새 배열을 `arr1.length + arr2.length` 크기로 만들고, 루프를 이용하여 데이터를 차례로 복사합니다.
 * 
 * [문제별 학습 목표]
 * - Lab6: 두 배열 하나로 합치기 (Problem 3 연계)
 */
import java.util.Arrays;

public class Example3 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab6: 두 배열 하나로 합치기 (Problem 3 연계) ---");
        Lab6.run();
    }

    static class Lab6 {
        static void run() {
            // Problem 3: 두 배열 합치기
            int[] arr1 = {1, 2, 3};
            int[] arr2 = {4, 5, 6};
            int[] combined = new int[arr1.length + arr2.length];

            // 1. 첫 번째 배열 복사
            for (int i = 0; i < arr1.length; i++) {
                combined[i] = arr1[i];
            }
            // 2. 두 번째 배열 복사 (오프셋 적용)
            for (int i = 0; i < arr2.length; i++) {
                combined[arr1.length + i] = arr2[i];
            }

            System.out.println("병합된 배열: " + Arrays.toString(combined));
        }
    }
}
