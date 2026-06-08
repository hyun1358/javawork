package week09.day3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [학습 예제 4] Week 09 Day 3 — 스트림의 map(변환), collect(수집) 및 정렬/중복제거
 * 
 * 3. sorted (정렬) & distinct (중복 제거) & limit (제한):
 *    - distinct(): 중복된 요소를 제거합니다.
 *    - limit(n): 앞에서부터 n개만큼만 데이터를 필터링하여 남깁니다.
 */
public class Example4 {
    public static void main(String[] args) {
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
