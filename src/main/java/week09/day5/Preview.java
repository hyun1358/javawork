package week09.day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [예습 파일] Week 09 Day 5 — 스트림 종합 활용 (복합 조건 처리)
 */
public class Preview {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "kiwi");

        // 길이가 5 이상인 단어들만 대문자로 변환한 뒤, 쉼표로 이어붙이기
        String result = list.stream()
                .filter(s -> s.length() >= 5)
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }
}
