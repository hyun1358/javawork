package week09.day5;

import java.util.Arrays;
import java.util.List;

public class Answer1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * 2)
                .forEach(System.out::println);
    }
}
