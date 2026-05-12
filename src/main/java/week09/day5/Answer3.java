package week09.day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Answer3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello World", "Java Stream");
        List<String> words = list.stream()
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(words);
    }
}
