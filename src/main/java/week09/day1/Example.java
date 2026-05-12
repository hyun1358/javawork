package week09.day1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * [학습 예제] Week 09 Day 1 — 람다식 활용과 메서드 참조
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: Comparator 람다식 ===");
        List<String> names = Arrays.asList("Lee", "Kim", "Park");
        // names.sort((s1, s2) -> s1.compareTo(s2)); // 람다식
        names.sort(String::compareTo); // 메서드 참조 (더 짧게!)
        System.out.println(names);

        System.out.println("\n=== Lab2: Runnable 람다식 ===");
        Runnable r = () -> System.out.println("스레드 실행");
        r.run();
    }
}
