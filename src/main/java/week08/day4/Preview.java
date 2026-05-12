package week08.day4;

import java.util.HashSet;

/**
 * [예습 파일] Week 08 Day 4 — HashSet 기초
 */
public class Preview {
    public static void main(String[] args) {
        // 중복을 허용하지 않고 순서를 보장하지 않는 집합
        HashSet<String> set = new HashSet<>();
        set.add("Java");
        set.add("Python");
        set.add("Java"); // 중복 삽입 (무시됨)

        System.out.println("저장된 개수: " + set.size()); // 2
        System.out.println("내용: " + set);
    }
}
