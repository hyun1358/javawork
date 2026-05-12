package week09.day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Answer4 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("사과", "바나나", "포도");
        String result = fruits.stream().collect(Collectors.joining(", ", "과일 목록: ", ""));
        System.out.println(result);
    }
}
