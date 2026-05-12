package week08.day2;

import java.util.HashMap;

public class Answer5 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "100");

        System.out.println("B값 조회: " + map.getOrDefault("B", "데이터 없음"));
    }
}
