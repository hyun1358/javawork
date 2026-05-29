package week09.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * [연습 문제 3] flatMap 활용
 * 문제: 문자열 리스트 {"Hello World", "Java Stream"}을
 * 공백을 기준으로 쪼개어 개별 단어의 리스트로 만드세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        List<String> sentences = Arrays.asList("Hello World", "Java Stream");
        List<String> word = sentences.stream().map(s-> s.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(word);
    }
}
