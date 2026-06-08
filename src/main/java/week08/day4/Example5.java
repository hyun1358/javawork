package week08.day4;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * [학습 예제 5] Week 08 Day 4 — 집합 연산 및 다양한 Map 특징
 * 
 * [보충 실습 코드 구성]
 * - TreeSet: 연습 문제 해결에 꼭 필요한 TreeSet 기술의 실제 실행 코드를 본문 하단에 [보충 Lab]으로 수록했습니다.
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n=== [보충 Lab] TreeSet을 이용한 자동 정렬 집합 ===");
        // TreeSet은 삽입되는 원소들을 자동으로 정렬(오름차순)하여 보관하는 이진 탐색 트리 집합 자료구조입니다.
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(3, 1, 4, 2));
        System.out.println("자동 정렬된 집합 구조: " + treeSet);

        System.out.println("\n=== Lab 3: TreeSet을 활용한 자동 오름차순 정렬 ===");
        Set<Integer> sortedSet = new TreeSet<>(Arrays.asList(30, 10, 20));
        System.out.println("TreeSet 결과 (자동 정렬): " + sortedSet); // [10, 20, 30]
    }
}
