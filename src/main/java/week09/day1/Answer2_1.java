package week09.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 다중 조건을 사용하여 문자열 리스트를 정렬하는 예제 클래스입니다.
public class Answer2_1 {
    public static void main(String[] args) {
        // 변경 가능한(가변 크기의) 리스트를 생성하고 초기값을 설정합니다.
        List<String> list = new ArrayList<>(Arrays.asList("Java", "C++", "Python", "JavaScript"));

        // 1. 문자열의 길이를 기준으로 내림차순 정렬하되, 
        // 2. 길이가 같을 경우에는 사전 순(오름차순)으로 정렬합니다.
        list.sort((s1, s2) -> {
            if (s1.length() != s2.length()) {
                // 두 문자열의 길이가 다를 경우, 길이를 기준으로 내림차순 정렬 (긴 것 -> 짧은 것)
                return s2.length() - s1.length(); 
            }
            // 길이가 같을 경우, String의 compareTo 메서드를 사용하여 사전 순으로 오름차순 정렬
            return s1.compareTo(s2);
        });

        // 정렬된 리스트의 결과를 출력합니다.
        System.out.println(list);
    }
}
