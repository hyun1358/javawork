package week09.day5;

import java.util.Arrays;
import java.util.List;

/**
 * [학습 예제 1] Week 09 Day 5 — for문과 스트림 비교, flatMap 및 객체 최솟값 검색
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("=== Lab1: for문을 스트림으로 리팩토링 ===");
        List<Integer> list = Arrays.asList(10, 20, 30);
        // 기존 for문
        for (int n : list) {
            if (n > 10) System.out.print(n + " ");
        }
        System.out.println();
        // 스트림으로 리팩토링 (홀수 찾아서 2배 만들기 등도 동일 메커니즘)
        list.stream().filter(n -> n > 10).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}
