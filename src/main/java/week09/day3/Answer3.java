package week09.day3;

import java.util.Arrays;
import java.util.List;

public class Answer3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(50, 80, 90, 40, 100);
        list.stream().filter(s -> s >= 70).sorted().forEach(System.out::println);
    }
}
