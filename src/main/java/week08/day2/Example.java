package week08.day2;

import java.util.HashMap;
import java.util.Map;

/**
 * [학습 예제] Week 08 Day 2 — HashMap 순회
 */
public class Example {
    public static void main(String[] args) {
        HashMap<String, String> dic = new HashMap<>();
        dic.put("Apple", "사과");
        dic.put("Water", "물");

        System.out.println("=== Lab1: keySet() 순회 ===");
        for (String key : dic.keySet()) {
            System.out.println(key + " -> " + dic.get(key));
        }

        System.out.println("\n=== Lab2: entrySet() 순회 (권장) ===");
        for (Map.Entry<String, String> entry : dic.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
