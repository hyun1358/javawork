package week09.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Answer2_1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Java", "C++", "Python", "JavaScript"));

        // 1. 문자열의 길이를 기준으로 내림차순 정렬하되, 
        // 2. 길이가 같을 경우에는 사전 순(오름차순)으로 정렬합니다.
        list.sort((s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s2.length() - s1.length(); // 내림차순 정렬 (큰 것 -> 작은 것)
            }
            return s1.compareTo(s2); // 사전 순 오름차순 정렬
        });

        System.out.println(list);
    }
}
