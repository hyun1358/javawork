package week09.day3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [학습 예제] Week 09 Day 3 — map과 collect
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: map (값 변환) ===");
        List<Integer> nums = Arrays.asList(1, 2, 3);
        nums.stream()
                .map(n -> n * 10) // 10, 20, 30으로 변환
                .forEach(System.out::println);

        System.out.println("\n=== Lab2: collect (다시 리스트로) ===");
        List<Integer> result = nums.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
