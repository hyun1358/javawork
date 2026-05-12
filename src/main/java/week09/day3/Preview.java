package week09.day3;

import java.util.Arrays;
import java.util.List;

/**
 * [예습 파일] Week 09 Day 3 — 스트림 (Stream) 기초
 */
public class Preview {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry", "Avocado");

        // 스트림: 생성 -> 중간 연산(filter) -> 최종 연산(forEach)
        list.stream()
                .filter(s -> s.startsWith("A")) // A로 시작하는 것만 필터링
                .forEach(s -> System.out.println(s)); // 출력
    }
}
