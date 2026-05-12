package week11.day2;

import java.util.*;

public class Answer1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 2);
        Sorter s = new Sorter((o1, o2) -> o2 - o1); // 내림차순 람다
        s.sort(list);
        System.out.println(list);
    }
}

class Sorter {
    Comparator<Integer> comp;

    Sorter(Comparator<Integer> c) {
        comp = c;
    }

    void sort(List<Integer> list) {
        list.sort(comp);
    }
}
