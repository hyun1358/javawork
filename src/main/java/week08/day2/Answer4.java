package week08.day2;

import java.util.HashMap;
import java.util.Map;

public class Answer4 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("KR", "Seoul");
        map.put("US", "Washington");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("국가: %s, 수도: %s\n", entry.getKey(), entry.getValue());
        }
    }
}
