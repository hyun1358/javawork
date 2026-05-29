package week09.day4;

import java.util.Arrays;
import java.util.List;

public class Answer1_1 {
    public static void main(String[] args) {
        // 숫자 리스트 초기화
        List<Integer> nums = Arrays.asList(10, 20, 30, 40, 50);

        // 스트림을 생성하여 IntStream으로 변환하고 평균값을 구함
        // 만약 리스트가 비어있다면 0.0을 기본값으로 반환
        double avg = nums.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        // 결과 출력
        System.out.println("평균: " + avg);
    }
}