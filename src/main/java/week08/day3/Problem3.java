package week08.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * [연습 문제 3] Comparator 구현 (이름순)
 * 문제: Student 클래스를 수정하지 말고, 외부에서 Comparator를 사용하여 이름순(사전순)으로 정렬하세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        Comparator<Student> comparator = new Comparator<Student>()
        {
            @Override
            public int compare(Student o1, Student o2)
            {
                return o1.name.compareTo(o2.name);
            }
        };

        List<Student> students = new ArrayList<>();
        students.add(new Student("일길동",40));
        students.add(new Student("이길동",50));
        students.add(new Student("삼길동",30));
        students.add(new Student("사길동",50));

        Collections.sort(students, comparator);

        for(Student s : students)
            System.out.println(s.name+" ");
    }

    static class Student
    {
        String name;
        int score;

        Student(String n,int s)
        {
            this.name = n;
            this.score=s;
        }
    }
}
