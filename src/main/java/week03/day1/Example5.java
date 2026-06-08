package week03.day1;

/**
 * [학습 예제 5] Week 03 Day 1 — 1차원 배열 기초
 * 
 * [연습 문제 1~5 해결을 위한 필수 핵심 기법]
 * - 최댓값 찾기: 기준값을 첫 번째 요소(`arr[0]`)로 설정한 후, 반복문을 돌며 더 큰 값이 나오면 기준값을 갱신합니다.
 * 
 * [문제별 학습 목표]
 * - Lab5: 배열에서 최댓값 찾기 (Problem 2 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab5: 배열에서 최댓값 찾기 (Problem 2 연계) ---");
        Lab5.run();
    }

    static class Lab5 {
        static void run() {
            // Problem 2: 최댓값 탐색 알고리즘
            int[] arr = {12, 45, 7, 23, 56, 32};
            int max = arr[0]; // 첫 번째 요소를 최댓값 후보로 설정
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i]; // 더 큰 값을 찾으면 최댓값 갱신
                }
            }
            System.out.println("배열 내 최댓값: " + max);
        }
    }
}
