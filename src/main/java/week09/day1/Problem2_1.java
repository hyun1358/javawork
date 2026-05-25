package week09.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [추가 연습 문제 2-1] 다중 조건 문자열 정렬 (람다식 응용)
 * 
 * 문제:
 * 제공된 문자열 리스트를 다음 조건에 맞게 정렬하는 코드를 람다식을 사용하여 작성해 보세요.
 * 
 * 정렬 조건:
 * 1. 문자열의 길이(length)를 기준으로 내림차순(긴 것부터 짧은 것 순으로) 정렬합니다.
 * 2. 만약 문자열의 길이가 같다면, 사전 오름차순(가나다/알파벳 순)으로 정렬합니다.
 * 
 * 출력 예시:
 * [JavaScript, Python, Java, C++]
 */
public class Problem2_1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Java", "C++", "Python", "JavaScript"));

        // TODO: 조건에 맞게 람다식을 작성하여 정렬해 보세요.
        list.sort((s1, s2) ->
        {
            if(s1.length() != s2.length())
            {
                return s2.length() - s1.length();
            }
            return s1.compareTo(s2);
        });

        System.out.println(list);
    }
}
