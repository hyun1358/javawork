package week09.day4;

import java.util.Arrays;

/**
 * [연습 문제 5_1] (보충) 기본형 스트림 최댓값 안전하게 꺼내기
 * 문제: 주어진 double 배열에서 스트림의 max() 메서드를 활용하여 최대값을 구하고, 값이 없을 경우 -1.0을 출력하게 하세요.
 */
public class Problem5_1 {
    public static void main(String[] args) {
        double[] arr = {1.5, 3.2, 2.8, 9.9, 4.1};

        // 사용자가 풀이한 코드 복구
        double max = Arrays.stream(arr)
                .max()
                .orElse(-1.0);

        System.out.println("최대값: " + max);
    }
}