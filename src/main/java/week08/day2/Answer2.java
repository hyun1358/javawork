package week08.day2;

import java.util.HashMap;

public class Answer2 {
    public static void main(String[] args) {
        String text = "apple banana apple orange";
        String[] words = text.split(" ");
        HashMap<String, Integer> map = new HashMap<>();

        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        System.out.println(map);
    }
}
