package week08.day1;

import java.util.ArrayList;

/**
 * [예습 파일] Week 08 Day 1 — ArrayList 기초
 */
public class Preview {
    public static void main(String[] args) {
        // 배열과 달리 크기가 늘어나는 리스트
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("총 개수: " + list.size());
        System.out.println("0번째: " + list.get(0));

        list.remove("Banana");
        System.out.println("삭제 후: " + list);
    }
}
