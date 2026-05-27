package week09.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [연습 문제 2] 스트림 매핑 (map)
 * 문제: 이름 리스트 {"kim", "lee", "park"}을 모두 대문자로 변환하여 출력하세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        List<String> names = new ArrayList<>(Arrays.asList("kim","lee","park"));

        names.stream().map(String::toUpperCase).forEach(name -> System.out.println("이름: " + name));
    }
}
