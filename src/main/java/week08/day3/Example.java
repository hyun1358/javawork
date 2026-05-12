package week08.day3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * [학습 예제] Week 08 Day 3 — Comparable 구현 (객체 정렬)
 */
public class Example {
    public static void main(String[] args) {
        ArrayList<Score> list = new ArrayList<>();
        list.add(new Score("A", 80));
        list.add(new Score("B", 95));
        list.add(new Score("C", 70));

        Collections.sort(list); // 점수 오름차순 기준으로 정렬됨
        for (Score s : list) System.out.println(s.name + ": " + s.val);
    }
}

// 정렬 기준을 가진 클래스
class Score implements Comparable<Score> {
    String name;
    int val;

    Score(String n, int v) {
        name = n;
        val = v;
    }

    @Override
    public int compareTo(Score o) {
        return this.val - o.val; // 오름차순
    }
}
