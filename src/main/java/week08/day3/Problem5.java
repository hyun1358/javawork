package week08.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * [연습 문제 5] Top 3 추출
 * 문제: 점수 리스트를 정렬한 후, 상위 3명의 점수만 뽑아서 출력하세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        List<Student> students = new ArrayList<>();
        students.add(new Student("일길동",50));
        students.add(new Student("이길동",65));
        students.add(new Student("삼길동",65));
        students.add(new Student("사길동",56));
        students.add(new Student("오길동",64));
        students.add(new Student("육길동",43));
        students.add(new Student("칠길동",34));

        Collections.sort(students);

        int rank = 0;
        int prevScore = -1;

        for(int i = 0; i < students.size(); i++)
        {
            Student s = students.get(i);

            if(s.score != prevScore)
                rank++;

            if(rank > 3) break;

            System.out.println(rank + "등: " + s.name + "(" + s.score + ")");

            prevScore=s.score;
        }
    }

    static class Student implements Comparable<Student>
    {
        String name;
        int score;

        Student(String name, int score)
        {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Student o1)
        {
            return o1.score - this.score;
        }
    }
}
