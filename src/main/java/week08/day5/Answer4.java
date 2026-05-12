package week08.day5;

import java.util.*;

public class Answer4 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<String> list2 = Arrays.asList("A", "B");
        printList(list1);
        printList(list2);
    }

    public static void printList(List<?> list) {
        System.out.println(list);
    }
}
