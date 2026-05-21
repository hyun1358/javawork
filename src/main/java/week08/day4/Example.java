package week08.day4;

import java.util.*;

/**
 * [학습 예제] Week 08 Day 4 — 집합 연산 및 다양한 Map 특징
 * 
 * 1. Set의 집합 연산:
 *    - retainAll(other): 교집합 (공통된 것만 남기기)
 *    - addAll(other): 합집합 (모두 합치기, 중복은 자동 제거)
 *    - removeAll(other): 차집합 (겹치는 것 빼기)
 * 
 * 2. 다양한 Map 구현체의 특징 (순서/정렬 차이):
 *    - HashMap: 순서가 전혀 없음 (가장 빠른 성능)
 *    - TreeMap: 내부적으로 '키(Key)'를 기준으로 데이터를 자동 오름차순 정렬하여 관리
 *    - LinkedHashMap: 데이터를 넣은 '삽입 순서'를 그대로 유지
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab 1: Set을 활용한 집합 연산 ===");
        // 매 연산마다 원본이 변하므로 새로운 Set을 생성해서 실습합니다.
        
        // 1) 교집합 (retainAll) - 공통된 원소만 남깁니다.
        Set<Integer> setA1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> setB1 = new HashSet<>(Arrays.asList(3, 4, 5, 6));
        setA1.retainAll(setB1);
        System.out.println("교집합 결과(A ∩ B): " + setA1); // [3, 4]

        // 2) 합집합 (addAll) - 두 집합의 원소를 모두 합칩니다. (중복은 자동 제거)
        Set<Integer> setA2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> setB2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));
        setA2.addAll(setB2);
        System.out.println("합집합 결과(A ∪ B): " + setA2); // [1, 2, 3, 4, 5, 6]

        // 3) 차집합 (removeAll) - 기준 집합에서 겹치는 원소들을 뺍니다.
        Set<Integer> setA3 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> setB3 = new HashSet<>(Arrays.asList(3, 4, 5, 6));
        setA3.removeAll(setB3);
        System.out.println("차집합 결과(A - B): " + setA3); // [1, 2]


        System.out.println("\n=== Lab 2: 다양한 Map의 순서/정렬 특징 ===");
        
        // 1) HashMap (순서 없음)
        System.out.println("[HashMap: 순서 없음]");
        Map<Integer, String> hmap = new HashMap<>();
        hmap.put(30, "삼십");
        hmap.put(10, "십");
        hmap.put(20, "이십");
        System.out.println("HashMap 내용: " + hmap); // 순서가 보장되지 않음

        // 2) TreeMap (키 기준 자동 오름차순 정렬)
        System.out.println("\n[TreeMap: 키 정렬]");
        Map<Integer, String> tmap = new TreeMap<>();
        tmap.put(30, "삼십");
        tmap.put(10, "십");
        tmap.put(20, "이십");
        System.out.println("TreeMap 내용: " + tmap); 
        for (Integer key : tmap.keySet()) {
            System.out.println(key + "번 데이터: " + tmap.get(key));
        }

        // 3) LinkedHashMap (입력한 삽입 순서 유지)
        System.out.println("\n[LinkedHashMap: 삽입 순서 유지]");
        Map<Integer, String> lmap = new LinkedHashMap<>();
        lmap.put(30, "삼십");
        lmap.put(10, "십");
        lmap.put(20, "이십");
        System.out.println("LinkedHashMap 내용: " + lmap); 
        for (Integer key : lmap.keySet()) {
            System.out.println(key + "번 데이터: " + lmap.get(key));
        }
    }
}
