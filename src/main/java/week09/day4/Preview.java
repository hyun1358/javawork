package week09.day4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * [예습 파일] Week 09 Day 4 — 집계 연산과 Optional
 */
public class Preview {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        // 1. 합계 구하기 (sum은 기본형 스트림에만 있음)
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println("합계: " + sum);

        // 2. Optional: null일 수도 있는 값을 포장하는 객체
        Optional<String> opt = Optional.ofNullable("Hello");
        opt.ifPresent(System.out::println); // 값이 있을 때만 출력

        Optional<String> empty = Optional.empty();
        System.out.println("빈 값 대체: " + empty.orElse("기본값"));
    }
}
