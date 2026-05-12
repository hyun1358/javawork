package week09.day4;

import java.util.Arrays;

public class Answer5 {
    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 9, 2};
        int max = Arrays.stream(arr).max().orElse(-1);
        System.out.println("최대값: " + max);
    }
}
