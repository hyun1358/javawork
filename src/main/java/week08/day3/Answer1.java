package week08.day3;

import java.util.*;

public class Answer1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 1, 5, 2, 3);
        Collections.sort(list);
        System.out.println("오름차순: " + list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("내림차순: " + list);
    }
}
