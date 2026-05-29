package week09.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [연습 문제 4] Collectors.joining
 * 문제: 과일 이름이 담긴 문자열 리스트(List<String>)를 받아 "과일 목록: 사과, 바나나, 포도" 와 같이
 * 쉼표로 연결된 하나의 문자열로 만드세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        List<String> fruits = new ArrayList<>(Arrays.asList("사과","바나나","포도"));
        String result = fruits.stream().collect(Collectors.joining(", "));
        System.out.println("과일목록: "+result);
    }
}
