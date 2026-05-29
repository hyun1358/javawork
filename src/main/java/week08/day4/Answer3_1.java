package week08.day4;

import java.util.*;

/**
 * Map의 세 가지 주요 구현체(HashMap, TreeMap, LinkedHashMap)의 차이점(순서 보장 방식)을 비교하는 예제입니다.
 */
public class Answer3_1 {
    public static void main(String[] args) {
        // 1. HashMap (순서 보장 안 됨)
        // 가장 빠르지만 키의 순서를 예측할 수 없습니다.
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(30, "C");
        hashMap.put(10, "A");
        hashMap.put(20, "B");
        System.out.println("HashMap      : " + hashMap); // [10=A, 20=B, 30=C] 또는 랜덤 (순서 없음)

        // 2. TreeMap (키 기준 자동 오름차순 정렬)
        // 키가 추가될 때 자동으로 오름차순(또는 지정된 정렬 기준)으로 정렬됩니다.
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(30, "C");
        treeMap.put(10, "A");
        treeMap.put(20, "B");
        System.out.println("TreeMap      : " + treeMap); // [10=A, 20=B, 30=C] (무조건 키 오름차순 정렬됨)

        // 3. LinkedHashMap (입력한 삽입 순서 유지)
        // 요소가 추가된 순서를 그대로 기억하고 유지합니다.
        Map<Integer, String> linkedMap = new LinkedHashMap<>();
        linkedMap.put(30, "C");
        linkedMap.put(10, "A");
        linkedMap.put(20, "B");
        System.out.println("LinkedHashMap: " + linkedMap); // [30=C, 10=A, 20=B] (입력한 30 -> 10 -> 20 순서 유지됨)
        
        /*
         * [정리]
         * - HashMap: 순서가 전혀 없음 (가장 빠름)
         * - TreeMap: Key를 기준으로 자동으로 정렬됨 (조금 느림)
         * - LinkedHashMap: 우리가 집어넣은(put) 순서를 똑같이 유지해줌 (순서 기억용)
         */
    }
}
