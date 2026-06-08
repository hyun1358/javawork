package week09.day4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * [학습 예제 3] Week 09 Day 4 — 그룹핑과 리듀스 및 toMap
 * 
 * [학습 핵심 이론: 스트림의 고급 가공 및 최종 처리]
 * 2. Collectors.groupingBy()를 이용한 그룹 분류:
 *    - 조건식에 따라 단순히 true/false(Boolean)로 분류할 수도 있지만, 삼항 연산자(Ternary Operator) 등을 사용하면 원하는 커스텀 문자열(예: "합격"/"불합격")을 Key로 갖는 그룹화 Map을 손쉽게 얻을 수 있습니다.
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("\n=== Lab3: groupingBy (조건별 커스텀 문자열 그룹화) ===");
        List<Integer> scores = Arrays.asList(50, 70, 45, 95, 80);
        // 단순히 n -> n >= 60 으로 분류하면 Map의 Key가 Boolean(true, false)이 되지만,
        // 아래처럼 삼항 연산자(n >= 60 ? "합격" : "불합격")를 활용하여 분류 기준을 작성하면 
        // Map의 Key를 "합격"/"불합격"이라는 의미 있는 문자열로 그룹핑하여 받아낼 수 있습니다!
        Map<String, List<Integer>> gradeMap = scores.stream()
                .collect(Collectors.groupingBy(n -> n >= 60 ? "합격" : "불합격"));
        System.out.println(gradeMap); // {합격=[70, 95, 80], 불합격=[50, 45]}
    }
}
