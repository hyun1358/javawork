package week09.day3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Answer5 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hi", "hello", "java", "a", "web");
        List<String> result = words.stream()
                .filter(w -> w.length() >= 3)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
