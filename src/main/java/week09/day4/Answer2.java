package week09.day4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Answer2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(50, 60, 40, 80, 90);
        Map<String, List<Integer>> map = list.stream()
                .collect(Collectors.groupingBy(s -> s >= 60 ? "합격" : "불합격"));
        System.out.println(map);
    }
}
