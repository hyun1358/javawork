package week09.day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [예습 파일] Week 09 Day 5 — 스트림 종합 활용 (복합 조건 처리 및 joining)
 * 
 * [핵심 개념: 스트림 파이프라인(Pipeline) 설계 및 문자열 결합]
 * 1. 복합 조건 필터링 (Complex Filtering)
 *    - `filter()` 메서드 내부의 람다식에서 논리 연산자(`&&`, `||`)를 활용하면 여러 조건을 한꺼번에 통과시키는 복합 필터링을 쉽게 구현할 수 있습니다.
 *    - 예: `filter(u -> u.age >= 20 && u.score >= 80)`
 * 
 * 2. Collectors.joining()를 이용한 문자열 병합
 *    - 최종 연산 단계에서 `collect(Collectors.joining(", "))`와 같이 선언하면, 스트림 안의 문자열 요소를 지정된 구분자(Delimiter)로 사이에 끼워 하나의 수려한 단일 문자열로 조립해 줍니다.
 *    - 앞부분이나 뒷부분에 고정 문자열 접두사/접미사를 붙일 수도 있습니다: `joining(", ", "접두사", "접미사")`
 */
public class Preview {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "kiwi");

        // 길이가 5 이상인 단어들만 대문자로 변환한 뒤, 쉼표로 이어붙이기
        // [필터] 5자 이상 -> [변환] 대문자화 -> [최종] 쉼표로 이어붙이기
        String result = list.stream()
                .filter(s -> s.length() >= 5)
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));

        System.out.println("과일 목록: " + result); // 과일 목록: BANANA, CHERRY
        
        // 접두사 및 접미사 추가 joining 예제
        String prefixSuffixResult = list.stream()
                .filter(s -> s.length() >= 5)
                .map(String::toUpperCase)
                .collect(Collectors.joining(", ", "과일 목록: [", "]"));
        System.out.println(prefixSuffixResult); // 과일 목록: [BANANA, CHERRY]
    }
}
