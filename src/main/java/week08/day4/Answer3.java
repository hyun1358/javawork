package week08.day4;

import java.util.*;

public class Answer3 {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("B", "2");
        map.put("C", "3");
        map.put("A", "1");
        System.out.println("삽입 순서 유지: " + map); // B, C, A 순서
    }
}
