package week08.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * [연습 문제 4] 다중 기준 정렬
 * 문제: 이름이 같으면 나이순(오름차순)으로 정렬하는 Comparator를 구현하세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        List<Student> students = new ArrayList<>();
        students.add(new Student("일길동",40));
        students.add(new Student("이길동",50));
        students.add(new Student("이길동",30));
        students.add(new Student("사길동",70));

        Comparator<Student> comparator = new Comparator<Student>()
        {
            @Override
            public int compare(Student o1, Student o2)
            {
                if(o1.name.equals(o2.name))
                {
                    return o1.age - o2.age;
                }
                return o1.name.compareTo(o2.name);
            }
        };

        Collections.sort(students,comparator);

        for(Student s : students)
        {
            System.out.printf("이름: %s, 나이: %d\n",s.name,s.age);

        }

    }

    static class Student
    {
        String name;
        int age;

        Student(String name,int age)
        {
            this.name = name;
            this.age=age;
        }
    }
}
