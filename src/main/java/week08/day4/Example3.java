package week08.day4;

import java.util.Map;
import java.util.TreeMap;

/**
 * [학습 예제 3] Week 08 Day 4 — 집합 연산 및 다양한 Map 특징
 * 
 * 2. 다양한 Map 구현체의 특징 (순서/정렬 차이):
 *    - TreeMap: 내부적으로 '키(Key)'를 기준으로 데이터를 자동 오름차순 정렬하여 관리
 */
public class Example3 {
    public static void main(String[] args) {
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
    }
}
