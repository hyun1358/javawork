package week08.day2;

import java.util.HashMap;
import java.util.Map;

/**
 * [학습 예제 2] Week 08 Day 2 — HashMap 전체 데이터 순회(Iteration)
 * 
 * 2. entrySet()을 이용한 순회:
 *    - 키와 값이 한 쌍으로 묶인 'Entry' 객체들을 통째로 꺼내옵니다.
 *    - 키와 값을 한 번에 다루기 때문에 성능상 가장 권장되는 방법입니다.
 */
public class Example2 {
    public static void main(String[] args) {
        HashMap<String, String> dic = new HashMap<>();
        dic.put("Apple", "사과");
        dic.put("Water", "물");
        dic.put("Mountain", "산");

        System.out.println("\n=== 2. entrySet()을 이용한 순회 (성능 최적화) ===");
        // .entrySet()은 '키:값' 한 쌍인 Entry 객체들의 보따리를 돌려줍니다.
        for (Map.Entry<String, String> entry : dic.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
