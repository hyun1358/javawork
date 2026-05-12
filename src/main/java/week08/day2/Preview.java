package week08.day2;

import java.util.HashMap;

/**
 * [예습 파일] Week 08 Day 2 — HashMap 기초
 */
public class Preview {
    public static void main(String[] args) {
        // 키-값 형태의 자료구조
        HashMap<String, Integer> map = new HashMap<>();
        map.put("사과", 1000);
        map.put("바나나", 1500);

        System.out.println("사과 가격: " + map.get("사과"));
        System.out.println("포도 가격: " + map.get("포도")); // 없으면 null 반환

        map.put("사과", 1200); // 덮어쓰기
        System.out.println("변경된 사과: " + map.get("사과"));
    }
}
