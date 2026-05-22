package week09.day5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * [학습 예제] Week 09 Day 5 — for문과 스트림 비교 및 flatMap, Comparator 탐색
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: for문을 스트림으로 리팩토링 ===");
        List<Integer> list = Arrays.asList(10, 20, 30);
        // 기존 for문
        for (int n : list) {
            if (n > 10) System.out.print(n + " ");
        }
        System.out.println();
        // 스트림
        list.stream().filter(n -> n > 10).forEach(n -> System.out.print(n + " "));

        System.out.println("\n\n=== Lab2: flatMap (리스트 평탄화) ===");
        List<List<String>> nested = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D")
        );
        List<String> flat = nested.stream()
                .flatMap(List::stream) // 리스트 안의 리스트들을 하나로 펼침
                .collect(Collectors.toList());
        System.out.println("평탄화 결과: " + flat);

        System.out.println("\n=== Lab3: Stream.of 및 Comparator를 활용한 최솟값 검색 ===");
        // Stream 클래스 직접 사용 및 Comparator 활용
        Stream<Integer> stream = Stream.of(5, 3, 9, 1, 7);
        int minVal = stream.min(Comparator.comparingInt(Integer::intValue)).orElse(-1);
        System.out.println("최솟값: " + minVal);
    }
}
