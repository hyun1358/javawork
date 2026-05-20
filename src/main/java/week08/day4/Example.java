package week08.day4;

import java.util.*;

/**
 * [학습 예제] Week 08 Day 4 — 집합 연산 및 TreeMap 기초
 * 
 * 1. Set의 집합 연산:
 *    - retainAll(other): 교집합 (공통된 것만 남기기)
 *    - addAll(other): 합집합 (모두 합치기, 중복은 자동 제거)
 *    - removeAll(other): 차집합 (겹치는 것 빼기)
 * 
 * 2. TreeMap:
 *    - HashMap과 비슷하게 '키-값'으로 저장하지만,
 *    - 내부적으로 '키(Key)'를 기준으로 데이터를 자동 정렬하여 관리합니다.
 *    - 정렬된 순서로 데이터를 꺼내야 할 때 매우 유용합니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab 1: Set을 활용한 교집합 구하기 ===");
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> setB = new HashSet<>(Arrays.asList(3, 4, 5, 6));

        // setA와 setB의 교집합을 setA에 담습니다.
        setA.retainAll(setB); 
        System.out.println("교집합 결과(A ∩ B): " + setA); // [3, 4]

        System.out.println("\n=== Lab 2: TreeMap의 자동 정렬 특징 ===");
        // TreeMap은 추가할 때마다 키(번호) 순서대로 줄을 세웁니다.
        Map<Integer, String> tmap = new TreeMap<>();
        tmap.put(30, "삼십");
        tmap.put(10, "십");
        tmap.put(20, "이십");

        // 입력 순서와 상관없이 10, 20, 30 순서로 출력됩니다.
        System.out.println("TreeMap 내용: " + tmap); 
        
        for (Integer key : tmap.keySet()) {
            System.out.println(key + "번 데이터: " + tmap.get(key));
        }
    }
}
