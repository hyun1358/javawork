package week08.day4;

import java.util.*;

/**
 * [학습 예제] Week 08 Day 4 — 집합 연산 및 TreeMap
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: 교집합(retainAll) ===");
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(3, 4, 5));
        s1.retainAll(s2);
        System.out.println("공통 부분: " + s1); // [3]

        System.out.println("\n=== Lab2: TreeMap 자동 정렬 ===");
        Map<Integer, String> tmap = new TreeMap<>();
        tmap.put(100, "C");
        tmap.put(50, "A");
        tmap.put(80, "B");
        System.out.println(tmap); // 키 순서대로 자동 정렬되어 출력됨
    }
}
