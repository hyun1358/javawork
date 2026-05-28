package week09.day4;

import java.util.Arrays;
import java.util.List;

public class Answer1_1 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(10, 20, 30, 40, 50);

        double avg = nums.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        System.out.println("평균: " + avg);
    }
}