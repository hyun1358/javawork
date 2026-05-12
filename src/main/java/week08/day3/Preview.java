package week08.day3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * [예습 파일] Week 08 Day 3 — 기본 정렬 (Collections.sort)
 */
public class Preview {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(50);
        list.add(10);
        list.add(30);

        Collections.sort(list); // 오름차순 정렬
        System.out.println("정렬: " + list);

        Collections.sort(list, Collections.reverseOrder()); // 내림차순
        System.out.println("역순: " + list);
    }
}
