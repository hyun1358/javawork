package week03.day2;

/**
 * [학습 예제 1] Week 03 Day 2 — 배열 정렬 및 응용
 * 
 * [학습 핵심 이론: 배열 조작 및 알고리즘 기초]
 * 1. Arrays.sort():
 *    - Java 내부에서 구현된 듀얼피벗 퀵정렬(Dual-Pivot Quicksort) 등을 사용하여 배열을 빠르고 효율적으로 오름차순 정렬합니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: Arrays.sort() 오름차순 정렬 (Problem 1 연계)
 */
import java.util.Arrays;

public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: Arrays.sort() 오름차순 정렬 (Problem 1 연계) ---");
        Lab1.run();
    }

    static class Lab1 {
        static void run() {
            int[] arr = {34, 12, 89, 5, 21};
            Arrays.sort(arr);
            System.out.println("Arrays.sort 정렬 결과: " + Arrays.toString(arr));
        }
    }
}
