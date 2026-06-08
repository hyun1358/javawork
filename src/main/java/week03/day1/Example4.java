package week03.day1;

/**
 * [학습 예제 4] Week 03 Day 1 — 1차원 배열 기초
 * 
 * [연습 문제 1~5 해결을 위한 필수 핵심 기법]
 * - 합계와 평균 구하기: 배열을 순회하며 누적 합(sum)을 구하고, 형변환 `(double)`을 사용해 정확한 평균을 계산합니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: 배열 합계와 평균 구하기 (Problem 1 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab4: 배열 합계와 평균 구하기 (Problem 1 연계) ---");
        Lab4.run();
    }

    static class Lab4 {
        static void run() {
            // Problem 1: 배열 요소의 합계와 평균 구하기
            int[] values = {88, 92, 79, 95, 80};
            int sum = 0;
            for (int i = 0; i < values.length; i++) {
                sum += values[i];
            }
            // 평균 계산 시 정수 나눗셈의 소수점 손실을 방지하기 위해 double형으로 변환합니다.
            double avg = (double) sum / values.length;
            System.out.println("배열 요소들의 합계: " + sum);
            System.out.println("배열 요소들의 평균: " + avg);
        }
    }
}
