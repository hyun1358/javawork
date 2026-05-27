package week09.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Answer3_1 {
    public static void main(String[] args) {
        List<Integer> scores = new ArrayList<>(Arrays.asList(65, 80, 55, 90, 75, 100));

        scores.stream()
              .filter(score -> score >= 70)
              .sorted()
              .forEach(System.out::println);
    }
}
