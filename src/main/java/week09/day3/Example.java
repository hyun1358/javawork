package week09.day3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [학습 예제] Week 09 Day 3 — 스트림의 map(변환), collect(수집) 및 정렬/중복제거
 * 
 * 1. map (데이터 변환):
 *    - 스트림 안의 데이터들을 다른 값이나 형태로 하나하나 바꿉니다.
 *    - 예: 숫자에 10 곱하기, 문자열을 대문자로 바꾸기 등
 * 
 * 2. collect (결과 수집):
 *    - 가공된 스트림의 데이터를 다시 리스트(List)나 셋(Set) 등으로 모아줍니다.
 *    - 스트림은 일회용이므로, 결과를 계속 쓰려면 collect(Collectors.toList()) 등으로 담아두어야 합니다.
 * 
 * 3. sorted (정렬) & distinct (중복 제거) & limit (제한):
 *    - sorted(): 데이터의 기본 순서(오름차순)대로 정렬합니다.
 *    - distinct(): 중복된 요소를 제거합니다.
 *    - limit(n): 앞에서부터 n개만큼만 데이터를 필터링하여 남깁니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab 1: map을 이용한 숫자 변환 ===");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        
        nums.stream()
                .map(n -> n * 10) // 모든 숫자를 10배로 뻥튀기!
                .forEach(n -> System.out.println("변환된 값: " + n));

        System.out.println("\n=== Lab 2: collect를 사용하여 결과 리스트 만들기 ===");
        // 2의 배수만 골라내서 100을 더한 뒤, 새로운 리스트로 저장하기
        List<Integer> result = nums.stream()
                .filter(n -> n % 2 == 0)      // 2, 4만 통과
                .map(n -> n + 100)            // 102, 104로 변환
                .collect(Collectors.toList()); // 리스트로 모으기
        
        System.out.println("최종 리스트: " + result); // [102, 104]

        System.out.println("\n=== Lab 3: 필터링 후 정렬 (sorted) ===");
        List<Integer> scores = Arrays.asList(50, 80, 95, 40, 100, 75);
        // 70점 이상인 사람만 골라 오름차순으로 정렬한 뒤 출력
        scores.stream()
                .filter(s -> s >= 70) // 80, 95, 100, 75만 통과
                .sorted()             // 오름차순 정렬: 75 -> 80 -> 95 -> 100
                .forEach(s -> System.out.println("합격생 점수: " + s));

        System.out.println("\n=== Lab 4: 중복 제거 및 제한 (distinct, limit) ===");
        List<Integer> repeatNums = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5);
        // 중복을 제거하고 앞에서 3개만 리스트로 수집
        List<Integer> processedList = repeatNums.stream()
                .distinct() // [1, 2, 3, 4, 5]
                .limit(3)   // [1, 2, 3]
                .collect(Collectors.toList());
        System.out.println("중복 제거 및 3개 제한 결과: " + processedList); // [1, 2, 3]
    }
}
