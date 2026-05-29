package week08.day3;

import java.util.*;

/**
 * Comparable 인터페이스를 구현하여 사용자 정의 객체의 기본 정렬 기준(내림차순)을 정의하는 예제입니다.
 */
public class Answer2 {
    public static void main(String[] args) {
        // Stud2 객체들을 담은 리스트를 생성합니다.
        List<Stud2> list = Arrays.asList(new Stud2(80), new Stud2(95), new Stud2(70));
        // Stud2 클래스가 구현한 Comparable의 compareTo 메서드 기준에 따라 정렬됩니다.
        Collections.sort(list);
        for (Stud2 s : list) System.out.println(s.score);
    }
}

// Comparable 인터페이스를 구현하여 객체 간의 비교 방법을 정의합니다.
class Stud2 implements Comparable<Stud2> {
    int score;

    Stud2(int s) {
        score = s;
    }

    // 비교 대상(o)의 점수에서 현재 객체(this)의 점수를 빼서 내림차순으로 정렬되도록 구현합니다.
    public int compareTo(Stud2 o) {
        return o.score - this.score;
    } // 내림차순
}
