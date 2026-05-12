package week09.day4;

import java.util.Arrays;
import java.util.List;

public class Answer1 {
    public static void main(String[] args) {
        List<Integer> scores = Arrays.asList(80, 90, 100);
        double avg = scores.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("평균: " + avg);
    }
}
