package week08.day2;

import java.util.HashMap;

/**
 * [학습 예제 1] Week 08 Day 2 — HashMap 전체 데이터 순회(Iteration)
 * 
 * HashMap은 인덱스(0, 1, 2...)가 없기 때문에 일반적인 for문으로는 데이터를 꺼낼 수 없습니다.
 * 맵 안에 있는 모든 데이터를 확인하려면 다음의 두 가지 방법을 주로 사용합니다.
 * 
 * 1. keySet()을 이용한 순회:
 *    - 모든 '키(Key)'들만 먼저 꺼내온 뒤, 각 키에 대응하는 값을 get(key)로 가져옵니다.
 *    - 코드가 직관적이지만, 대량의 데이터에서는 속도가 조금 느릴 수 있습니다.
 */
public class Example1 {
    public static void main(String[] args) {
        HashMap<String, String> dic = new HashMap<>();
        dic.put("Apple", "사과");
        dic.put("Water", "물");
        dic.put("Mountain", "산");

        System.out.println("=== 1. keySet()을 이용한 순회 ===");
        // .keySet()은 모든 Key들을 보따리(Set)에 담아 돌려줍니다.
        for (String key : dic.keySet()) {
            String value = dic.get(key);
            System.out.println("키: " + key + ", 값: " + value);
        }
    }
}
