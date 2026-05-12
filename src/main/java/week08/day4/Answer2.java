package week08.day4;

import java.util.*;

public class Answer2 {
    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(3, 4, 5));
        s1.removeAll(s2);
        System.out.println("차집합: " + s1);
    }
}
