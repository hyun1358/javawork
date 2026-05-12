package week09.day1;

import java.util.*;

public class Answer2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Banana", "Apple", "Kiwi");
        list.sort((s1, s2) -> s1.length() - s2.length());
        System.out.println(list);
    }
}
