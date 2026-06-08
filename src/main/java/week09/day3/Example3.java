package week09.day3;

import java.util.Arrays;
import java.util.List;

/**
 * [학습 예제 3] Week 09 Day 3 — 스트림의 map(변환), collect(수집) 및 정렬/중복제거
 * 
 * 3. sorted (정렬) & distinct (중복 제거) & limit (제한):
 *    - sorted(): 데이터의 기본 순서(오름차순)대로 정렬합니다.
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("\n=== Lab 3: 필터링 후 정렬 (sorted) ===");
        List<Integer> scores = Arrays.asList(50, 80, 95, 40, 100, 75);
        // 70점 이상인 사람만 골라 오름차순으로 정렬한 뒤 출력
        scores.stream()
                .filter(s -> s >= 70) // 80, 95, 100, 75만 통과
                .sorted()             // 오름차순 정렬: 75 -> 80 -> 95 -> 100
                .forEach(s -> System.out.println("합격생 점수: " + s));
    }
}
