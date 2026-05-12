package week08.day3;

import java.util.*;

public class Answer2 {
    public static void main(String[] args) {
        List<Stud2> list = Arrays.asList(new Stud2(80), new Stud2(95), new Stud2(70));
        Collections.sort(list);
        for (Stud2 s : list) System.out.println(s.score);
    }
}

class Stud2 implements Comparable<Stud2> {
    int score;

    Stud2(int s) {
        score = s;
    }

    public int compareTo(Stud2 o) {
        return o.score - this.score;
    } // 내림차순
}
