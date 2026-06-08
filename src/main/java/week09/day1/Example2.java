package week09.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [학습 예제 2] Week 09 Day 1 — 람다식(Lambda Expression)과 함수형 인터페이스
 * 
 * [문제별 학습 목표]
 * - Lab2: 문자열 리스트의 길이(length) 기준 다형적 람다 정렬 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab2: 문자열 리스트의 길이(length) 기준 다형적 람다 정렬 (Problem 2 연계) ---");
        Lab2.run();
    }

    static class Lab2 {
        static void run() {
            // Problem 2: 문자열 리스트를 길이 순으로 정렬
            List<String> fruits = new ArrayList<>(Arrays.asList("asd", "asdasd", "asgdff", "adtsafertg"));
            System.out.println("정렬 전: " + fruits);

            // 람다식을 이용해 Comparator 인터페이스의 compare() 메서드 완성
            fruits.sort((s1, s2) -> s1.length() - s2.length());
            System.out.println("길이 기준 오름차순 정렬 후: " + fruits);
        }
    }
}
