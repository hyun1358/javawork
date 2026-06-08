package week08.day4;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * [학습 예제 4] Week 08 Day 4 — 집합 연산 및 다양한 Map 특징
 * 
 * 2. 다양한 Map 구현체의 특징 (순서/정렬 차이):
 *    - LinkedHashMap: 데이터를 넣은 '삽입 순서'를 그대로 유지
 */
public class Example4 {
    public static void main(String[] args) {
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
