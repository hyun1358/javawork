package week08.day1;

import java.util.ArrayList;
import java.util.Arrays;

public class Answer2 {
    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(80, 90, 100));
        int sum = 0;
        for (int s : scores) sum += s;
        System.out.println("합계: " + sum + ", 평균: " + (sum / scores.size()));
    }
}
