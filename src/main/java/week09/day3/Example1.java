package week09.day3;

import java.util.Arrays;
import java.util.List;

/**
 * [학습 예제 1] Week 09 Day 3 — 스트림의 map(변환), collect(수집) 및 정렬/중복제거
 * 
 * 1. map (데이터 변환):
 *    - 스트림 안의 데이터들을 다른 값이나 형태로 하나하나 바꿉니다.
 *    - 예: 숫자에 10 곱하기, 문자열을 대문자로 바꾸기 등
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("=== Lab 1: map을 이용한 숫자 변환 ===");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        
        nums.stream()
                .map(n -> n * 10) // 모든 숫자를 10배로 뻥튀기!
                .forEach(n -> System.out.println("변환된 값: " + n));
    }
}
