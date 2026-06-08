package week08.day4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * [학습 예제 1] Week 08 Day 4 — 집합 연산 및 다양한 Map 특징
 * 
 * 1. Set의 집합 연산:
 *    - retainAll(other): 교집합 (공통된 것만 남기기)
 *    - addAll(other): 합집합 (모두 합치기, 중복은 자동 제거)
 *    - removeAll(other): 차집합 (겹치는 것 빼기)
 */
public class Example1 {
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
    }
}
