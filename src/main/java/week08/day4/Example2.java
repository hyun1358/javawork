package week08.day4;

import java.util.HashMap;
import java.util.Map;

/**
 * [학습 예제 2] Week 08 Day 4 — 집합 연산 및 다양한 Map 특징
 * 
 * 2. 다양한 Map 구현체의 특징 (순서/정렬 차이):
 *    - HashMap: 순서가 전혀 없음 (가장 빠른 성능)
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("\n=== Lab 2: 다양한 Map의 순서/정렬 특징 ===");
        
        // 1) HashMap (순서 없음)
        System.out.println("[HashMap: 순서 없음]");
        Map<Integer, String> hmap = new HashMap<>();
        hmap.put(30, "삼십");
        hmap.put(10, "십");
        hmap.put(20, "이십");
        System.out.println("HashMap 내용: " + hmap); // 순서가 보장되지 않음
    }
}
