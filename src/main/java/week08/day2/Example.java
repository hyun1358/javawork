package week08.day2;

import java.util.HashMap;
import java.util.Map;

/**
 * [학습 예제] Week 08 Day 2 — HashMap 전체 데이터 순회(Iteration)
 * 
 * HashMap은 인덱스(0, 1, 2...)가 없기 때문에 일반적인 for문으로는 데이터를 꺼낼 수 없습니다.
 * 맵 안에 있는 모든 데이터를 확인하려면 다음의 두 가지 방법을 주로 사용합니다.
 * 
 * 1. keySet()을 이용한 순회:
 *    - 모든 '키(Key)'들만 먼저 꺼내온 뒤, 각 키에 대응하는 값을 get(key)로 가져옵니다.
 *    - 코드가 직관적이지만, 대량의 데이터에서는 속도가 조금 느릴 수 있습니다.
 * 
 * 2. entrySet()을 이용한 순회:
 *    - 키와 값이 한 쌍으로 묶인 'Entry' 객체들을 통째로 꺼내옵니다.
 *    - 키와 값을 한 번에 다루기 때문에 성능상 가장 권장되는 방법입니다.
 
 * 
 * [보충 이론 학습 가이드]
 * - split: 해당 일차 연습 문제 해결에 필수적인 split 기술 활용법을 보충 예제로 추가 설명했습니다.
*/
public class Example {
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
        
        System.out.println("\n=== [보충 Lab] String.split()을 이용한 정규식 문자열 분할 ===");
        // split은 지정된 구분문자(정규식)를 쪼개어 String[] 배열로 파싱해 줍니다.
        String[] tokens = "사과,바나나,포도".split(",");
        System.out.println("분할된 토큰 배열: " + java.util.Arrays.toString(tokens));
}

        System.out.println("\n=== 2. entrySet()을 이용한 순회 (성능 최적화) ===");
        // .entrySet()은 '키:값' 한 쌍인 Entry 객체들의 보따리를 돌려줍니다.
        for (Map.Entry<String, String> entry : dic.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
