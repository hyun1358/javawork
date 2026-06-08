package week03.day2;

/**
 * [학습 예제 4] Week 03 Day 2 — 배열 정렬 및 응용
 * 
 * [학습 핵심 이론: 배열 조작 및 알고리즘 기초]
 * 4. 중첩 루프를 이용한 중복 검색:
 *    - 이중 `for`문 구조로, 바깥 인덱스 `i`와 안쪽 인덱스 `j = i + 1`을 순차 비교해 가며 중복 요소를 검출해 냅니다.
 * 
 * [문제별 학습 목표]
 * - Lab7: 중첩 루프로 중복 값 찾기 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab7: 중첩 루프로 중복 값 찾기 (Problem 4 연계) ---");
        Lab7.run();
    }

    static class Lab7 {
        static void run() {
            // Problem 4: 중복된 요소 찾기
            int[] nums = {10, 20, 30, 20, 40, 10};
            System.out.print("검출된 중복 숫자: ");
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        System.out.print(nums[i] + " ");
                    }
                }
            }
            System.out.println();
        }
    }
}
