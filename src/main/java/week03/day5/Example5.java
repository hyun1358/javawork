package week03.day5;

/**
 * [학습 예제 5] Week 03 Day 5 — Math API와 난수 생성
 * 
 * [학습 핵심 이론: Math 클래스와 난수(Random) 활용]
 * 3. Math.abs(value):
 *    - 인자로 전달된 정수 또는 실수의 절대값(양수화)을 계산해 반환합니다.
 * 
 * [문제별 학습 목표]
 * - Lab5: 배열 요소들의 절대값 합산 및 평균 계산 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab5: 배열 요소들의 절대값 합산 및 평균 계산 (Problem 5 연계) ---");
        Lab5.run();
    }

    static class Lab5 {
        static void run() {
            // Problem 5: 배열 각 요소의 절대값의 합과 평균 계산
            int[] nums = {-10, 20, -30, 40};
            int sum = 0;

            for (int i = 0; i < nums.length; i++) {
                // Math.abs를 통해 양수화하여 합산
                sum += Math.abs(nums[i]);
            }
            double avg = (double) sum / nums.length;

            System.out.println("배열 절대값들의 합계: " + sum);
            System.out.println("배열 절대값들의 평균: " + avg);
        }
    }
}
