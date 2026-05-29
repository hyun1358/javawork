package week08.day2;

import java.util.HashMap;
import java.util.Map;

/**
 * Map.Entry를 사용하여 HashMap의 모든 키와 값을 순회(Iteration)하는 예제입니다.
 */
public class Answer4 {
    public static void main(String[] args) {
        // 국가 코드를 키로, 수도 이름을 값으로 저장하는 HashMap입니다.
        HashMap<String, String> map = new HashMap<>();
        map.put("KR", "Seoul");
        map.put("US", "Washington");

        // entrySet() 메서드는 Map의 모든 키-값 쌍을 Set 형태로 반환합니다.
        // 향상된 for문으로 각 Entry를 순회하며 getKey()와 getValue()를 통해 접근합니다.
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("국가: %s, 수도: %s\n", entry.getKey(), entry.getValue());
        }
    }
}
