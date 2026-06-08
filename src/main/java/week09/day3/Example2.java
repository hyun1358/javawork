package week09.day3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [학습 예제 2] Week 09 Day 3 — 스트림의 map(변환), collect(수집) 및 정렬/중복제거
 * 
 * 2. collect (결과 수집):
 *    - 가공된 스트림의 데이터를 다시 리스트(List)나 셋(Set) 등으로 모아줍니다.
 *    - 스트림은 일회용이므로, 결과를 계속 쓰려면 collect(Collectors.toList()) 등으로 담아두어야 합니다.
 */
public class Example2 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("\n=== Lab 2: collect를 사용하여 결과 리스트 만들기 ===");
        // 2의 배수만 골라내서 100을 더한 뒤, 새로운 리스트로 저장하기
        List<Integer> result = nums.stream()
                .filter(n -> n % 2 == 0)      // 2, 4만 통과
                .map(n -> n + 100)            // 102, 104로 변환
                .collect(Collectors.toList()); // 리스트로 모으기
        
        System.out.println("최종 리스트: " + result); // [102, 104]
    }
}
