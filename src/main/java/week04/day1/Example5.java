package week04.day1;

/**
 * [학습 예제 5] Week 04 Day 1 — 메서드 정의와 호출
 * 
 * [문제별 학습 목표]
 * - Lab5: 세 정수 중 최댓값 구하기 메서드 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        // Problem 5: 세 개의 정수 중 최댓값을 반환하는 max 메서드 호출
        int biggest = max(10, 25, 7);
        System.out.println("10, 25, 7 중 최댓값: " + biggest);
    }

    static int max(int a, int b, int c) {
        int maxVal = a; // 첫 번째 값을 최댓값으로 가정
        if (b > maxVal) {
            maxVal = b;
        }
        if (c > maxVal) {
            maxVal = c;
        }
        return maxVal;
    }
}
