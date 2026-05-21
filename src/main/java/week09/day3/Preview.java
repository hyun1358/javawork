package week09.day3;

import java.util.Arrays;
import java.util.List;

/**
 * [예습 파일] Week 09 Day 3 — 스트림(Stream) 기초 개념
 * 
 * 스트림은 데이터의 흐름입니다. 
 * 리스트나 배열에 담긴 데이터를 하나씩 꺼내서 원하는 대로 가공(필터링, 변환)한 뒤 
 * 결과를 내놓는 아주 편리한 도구입니다.
 * 
 * [스트림 사용 3단계]
 * 1. 생성: 데이터 소스로부터 스트림을 만듭니다. (.stream())
 * 2. 중간 연산: 데이터를 가공합니다. (filter, map 등) 
 *    - 여러 번 연결해서 쓸 수 있습니다. (파이프라인)
 * 3. 최종 연산: 결과를 내거나 출력하며 스트림을 닫습니다. (forEach, collect 등)
 */
public class Preview {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry", "Avocado", "Blueberry");

        System.out.println("=== A로 시작하는 과일만 찾아서 출력하기 ===");
        
        // 1. 생성 (.stream())
        list.stream()
                // 2. 중간 연산 (.filter) : 조건에 맞는 것만 통과시킵니다.
                .filter(s -> s.startsWith("A")) 
                // 3. 최종 연산 (.forEach) : 각 요소를 출력합니다.
                .forEach(s -> System.out.println("찾은 과일: " + s));
    }
}
