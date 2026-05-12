package week09.day4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * [학습 예제] Week 09 Day 4 — 그룹핑과 리듀스
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: reduce로 곱셈 합 구하기 ===");
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int multi = list.stream().reduce(1, (a, b) -> a * b);
        System.out.println("모두 곱한 값: " + multi);

        System.out.println("\n=== Lab2: groupingBy (그룹화) ===");
        List<String> names = Arrays.asList("Kim", "Kang", "Lee", "Lim");
        Map<Character, List<String>> map = names.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(map); // 첫 글자별 묶임
    }
}
