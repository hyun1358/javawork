package week09.day3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [학습 예제] Week 09 Day 3 — 스트림의 map(변환)과 collect(수집)
 * 
 * 1. map (데이터 변환):
 *    - 스트림 안의 데이터들을 다른 값이나 형태로 하나하나 바꿉니다.
 *    - 예: 숫자에 10 곱하기, 문자열을 숫자로 바꾸기, 대문자로 바꾸기 등
 * 
 * 2. collect (결과 수집):
 *    - 가공된 스트림의 데이터를 다시 리스트(List)나 셋(Set) 등으로 모아줍니다.
 *    - 스트림은 일회용이므로, 결과를 계속 쓰려면 어딘가에 다시 담아야 합니다.
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
    }
}
