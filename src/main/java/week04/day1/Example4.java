package week04.day1;

/**
 * [학습 예제 4] Week 04 Day 1 — 메서드 정의와 호출
 * 
 * [학습 핵심 이론: 코드 재사용의 기본 - 메서드]
 * 3. JVM stack 영역의 동작:
 *    - 메서드가 호출되면 Call Stack에 해당 메서드만의 로컬 스택 프레임(Stack Frame)이 쌓이며, 메서드 종료 시 깨끗하게 소멸합니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: 메서드 내 로컬 배열 선언 및 합계 계산 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        // Problem 4: 메서드 내부 지역 범위에 배열을 선언하고 그 합을 구하기
        printArraySum();
    }

    static void printArraySum() {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("로컬 배열 요소들의 합계: " + sum);
    }
}
