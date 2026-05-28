package week09.day4;

import java.util.Arrays;
import java.util.List;

/**
 * [연습 문제 1_1] (보충) 값 안전하게 추출하기
 * 문제: 아래 리스트 요소들의 평균을 구하고, 값이 없을 경우를 대비하여 orElse()를 사용해 0.0을 출력하세요.
 */
public class Problem1_1 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(10, 20, 30, 40, 50);

        // 사용자가 풀이한 코드 복구
        double avg = nums.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        System.out.println("평균: " + avg);
    }
}