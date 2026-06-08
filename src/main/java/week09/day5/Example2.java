package week09.day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [학습 예제 2] Week 09 Day 5 — for문과 스트림 비교, flatMap 및 객체 최솟값 검색
 * 
 * [학습 핵심 이론: 루프의 스트림 전환 및 고성능 변환 API]
 * 1. flatMap (평탄화 연산)과 배열 스트림 변환:
 *    - `flatMap`은 2차원적인 데이터나 중첩된 구조를 1차원 선형 스트림으로 일렬로 펼치는 기법입니다.
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("\n=== Lab2: flatMap (중첩 리스트 및 문자열 쪼개기 평탄화) ===");
        // 예시 A: 중첩 리스트 평탄화
        List<List<String>> nested = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D")
        );
        System.out.println(nested);

        List<String> flat = nested.stream()
                .flatMap(List::stream) // 리스트 안의 리스트들을 하나로 펼침
                .collect(Collectors.toList());
        System.out.println("리스트 평탄화 결과: " + flat); // [A, B, C, D]
    }
}
