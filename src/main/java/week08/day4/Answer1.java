package week08.day4;

import java.util.*;

public class Answer1 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 2, 3, 3, 4};
        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
        System.out.println("중복 제거: " + set);
    }
}
