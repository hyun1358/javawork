package week09.day3;

import java.util.Arrays;
import java.util.List;

public class Answer2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("kim", "lee", "park");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
