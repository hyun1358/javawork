package week03.day4;

import java.util.Arrays;

/**
 * [학습 예제] Week 03 Day 4 — 배열 유틸리티
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: 문자열 배열 정렬 ===");
        Lab1.run();

        System.out.println("\n=== Lab2: 이진 탐색 (Binary Search) ===");
        Lab2.run();
    }

    static class Lab1 {
        static void run() {
            String[] arr = {"Pineapple", "Apple", "Orange", "Banana"};
            Arrays.sort(arr);
            System.out.println("정렬 결과: " + Arrays.toString(arr));
        }
    }

    static class Lab2 {
        static void run() {
            int[] nums = {10, 20, 30, 40, 50};
            int index = Arrays.binarySearch(nums, 30);
            System.out.println("30의 위치: " + index);
        }
    }
}
