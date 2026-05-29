package week08.day2;

import java.util.HashMap;

/**
 * HashMap의 getOrDefault 메서드를 사용하여 키가 존재하지 않을 때의 기본값을 처리하는 예제입니다.
 */
public class Answer5 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "100");

        // 키 "B"가 맵에 존재하지 않으므로, 두 번째 인자로 전달한 "데이터 없음"이 반환됩니다.
        System.out.println("B값 조회: " + map.getOrDefault("B", "데이터 없음"));
    }
}
