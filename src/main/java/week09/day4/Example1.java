package week09.day4;

import java.util.Arrays;
import java.util.List;

/**
 * [학습 예제 1] Week 09 Day 4 — 그룹핑과 리듀스 및 toMap
 * 
 * [학습 핵심 이론: 스트림의 고급 가공 및 최종 처리]
 * 1. reduce(초기값, accumulator) 연산:
 *    - 스트림의 요소를 소비해가며 지정된 누적 동작(lambda)을 통해 하나의 단일 결과로 축소(reduce)하는 강력한 커스텀 최종 연산입니다.
 *    - 예: `reduce(1, (a, b) -> a * b)`는 1부터 시작해 스트림의 모든 정수를 차례로 곱해 단일 총 곱값을 도출해 냅니다.
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("=== Lab1: reduce로 곱셈 합 구하기 ===");
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // reduce(identity, accumulator) 연산:
        // identity(1)는 연산의 초기값이고, accumulator((a, b) -> a * b)는 두 요소를 결합하여 하나의 결과를 내는 람다식입니다.
        // 스트림의 요소를 돌며 1 * 1 = 1, 1 * 2 = 2, 2 * 3 = 6, 6 * 4 = 24와 같이 누적 곱을 처리하여 단일 최종 결과를 도출합니다.
        int multi = list.stream().reduce(1, (a, b) -> a * b);
        System.out.println("모두 곱한 값: " + multi);
    }
}
