package week09.day4;

import java.util.Arrays;

public class Answer5_1 {
    public static void main(String[] args) {
        // 실수 배열 초기화
        double[] arr = {1.5, 3.2, 2.8, 9.9, 4.1};

        // double 배열을 스트림으로 변환하여 최대값(max)을 계산
        // 배열이 비어있어서 최대값이 없는 경우 -1.0을 반환
        double max = Arrays.stream(arr)
                .max()
                .orElse(-1.0);

        // 결과 출력
        System.out.println("최대값: " + max);
    }
}