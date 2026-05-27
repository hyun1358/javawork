package week09.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [연습 문제 5] 수집 (collect)
 * 문제: 단어 리스트에서 길이가 3 이상인 단어만 골라 "새로운 리스트"로 저장한 뒤 그 리스트를 출력하세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        List<String> strs = new ArrayList<>(Arrays.asList("Java","Python","C++","JavaScript","a"));
        List<String> newStr = strs.stream().filter(s->s.length()>=3).collect(Collectors.toList());

        for(String s: newStr)
        {
            System.out.println(s);
        }
    }
}
