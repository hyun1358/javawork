package week08.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * [학습 예제 1] Week 08 Day 3 — 객체의 정렬과 비교 Comparable/Comparator
 * 
 * [문제별 학습 목표]
 * - Lab1: Collections.sort()를 통한 정수 리스트 정렬 & 역정렬 (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: Collections.sort()를 통한 정수 리스트 정렬 & 역정렬 (Problem 1 연계) ---");
        Lab1.run();
    }

    static class Lab1 {
        static void run() {
            // Problem 1: 숫자 리스트 정렬
            List<Integer> numbers = new ArrayList<>(Arrays.asList(45, 10, 30, 20, 50, 6, 324));
            System.out.println("정렬 전: " + numbers);

            // 오름차순 정렬
            Collections.sort(numbers);
            System.out.println("오름차순 정렬 결과: " + numbers);

            // 내림차순 정렬
            Collections.sort(numbers, Collections.reverseOrder());
            System.out.println("내림차순 정렬 결과: " + numbers);
        }
    }
}
