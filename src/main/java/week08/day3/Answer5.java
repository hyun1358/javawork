package week08.day3;

import java.util.*;

public class Answer5 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(50, 90, 80, 100, 60);
        list.sort(Collections.reverseOrder());
        System.out.println("Top 3:");
        for (int i = 0; i < 3; i++) System.out.println(list.get(i));
    }
}
