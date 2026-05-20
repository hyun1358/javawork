package week08.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * [연습 문제 2] Comparable 구현
 * 문제: Student 클래스(점수 필드)가 Comparable을 구현하게 하여
 * 점수 내림차순(높은 순)으로 정렬되게 작성하세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        List<Student> students = new ArrayList<>();

        students.add(new Student("일길동",50));
        students.add(new Student("이길동",80));
        students.add(new Student("삼길동",60));
        students.add(new Student("사길동",70));

        Collections.sort(students, Collections.reverseOrder());

        for(Student s : students)
            System.out.printf("이름: %s, 점수: %d\n",s.name,s.score);
    }

    static class Student implements Comparable<Student>
    {
        String name;
        int score;

        Student(String n,int s)
        {
            this.name = n;
            this.score=s;
        }

        @Override
        public int compareTo(Student s)
        {
            return this.score - s.score;
        }
    }
}
