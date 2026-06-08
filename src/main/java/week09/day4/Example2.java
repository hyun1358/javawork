package week09.day4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * [학습 예제 2] Week 09 Day 4 — 그룹핑과 리듀스 및 toMap
 * 
 * [학습 핵심 이론: 스트림의 고급 가공 및 최종 처리]
 * 2. Collectors.groupingBy()를 이용한 그룹 분류:
 *    - 스트림 안의 데이터 객체들을 지정한 특성(키) 기준으로 쪼개어 분류한 뒤, Map 자료형(`Map<Key, List<Element>>`)으로 깔끔히 모아 수집(collect)하는 실무 핵심형 기법입니다.
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("\n=== Lab2: groupingBy (문자열 첫 글자별 그룹화) ===");
        List<String> names = Arrays.asList("Kim", "Kang", "Lee", "Lim");
        // Collectors.groupingBy(classifier):
        // classifier 람다식(s -> s.charAt(0))을 기준 열쇠 삼아 스트림 요소를 분류하고, 결과를 Map<Character, List<String>> 형태로 수집(collect)합니다.
        Map<Character, List<String>> map = names.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(map); // 첫 글자별 묶임
    }
}
