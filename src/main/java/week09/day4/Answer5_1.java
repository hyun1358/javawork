package week09.day4;

import java.util.Arrays;

public class Answer5_1 {
    public static void main(String[] args) {
        double[] arr = {1.5, 3.2, 2.8, 9.9, 4.1};

        double max = Arrays.stream(arr)
                .max()
                .orElse(-1.0);

        System.out.println("최대값: " + max);
    }
}