package week09.day3;

import java.util.Arrays;

public class Answer4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4, 5};
        Arrays.stream(arr).distinct().limit(3).forEach(System.out::println);
    }
}
