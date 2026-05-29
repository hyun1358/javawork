package week08.day2;

import java.util.HashMap;

/**
 * HashMap을 활용하여 문자열 내 단어의 출현 빈도수를 계산하는 예제입니다.
 */
public class Answer2 {
    public static void main(String[] args) {
        String text = "apple banana apple orange";
        // 공백을 기준으로 문자열을 분리하여 단어 배열을 만듭니다.
        String[] words = text.split(" ");
        // 단어(String)를 키로, 출현 횟수(Integer)를 값으로 갖는 HashMap을 생성합니다.
        HashMap<String, Integer> map = new HashMap<>();

        // 배열의 모든 단어를 순회합니다.
        for (String w : words) {
            // getOrDefault 메서드로 현재 단어의 빈도수를 가져오고(없으면 0), 1을 더해 다시 저장합니다.
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        // 최종적으로 계산된 각 단어별 빈도수를 출력합니다.
        System.out.println(map);
    }
}
