package week09.day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [학습 예제 3] Week 09 Day 5 — for문과 스트림 비교, flatMap 및 객체 최솟값 검색
 * 
 * [학습 핵심 이론: 루프의 스트림 전환 및 고성능 변환 API]
 * 1. flatMap (평탄화 연산)과 배열 스트림 변환:
 *    - 문자열 문장을 단어 단위로 쪼갤 때, `.map(s -> s.split(" "))`를 수행하면 결과가 `Stream<String[]>`이 됩니다.
 *    - 이 배열들을 문자열 요소로 1차원 평탄화하기 위해 `.flatMap(Arrays::stream)`을 사용하면 개별 단어들이 한 줄로 이어지는 `Stream<String>`을 깔끔히 수확할 수 있습니다.
 */
public class Example3 {
    public static void main(String[] args) {
        // 예시 B: 공백 문자열 분할 및 배열 평탄화 (실전 필수 문법!)
        List<String> sentences = Arrays.asList("Hello World", "Java Stream");
        List<String> words = sentences.stream()
                .map(s -> s.split(" "))   // 각 문장을 String[]로 쪼갬 (Stream<String[]>)
                .flatMap(Arrays::stream)  // String[] 배열들을 단어 스트림으로 평탄화 (Stream<String>)
                .collect(Collectors.toList());
        System.out.println("단어 분리 평탄화 결과: " + words); // [Hello, World, Java, Stream]
    }
}
