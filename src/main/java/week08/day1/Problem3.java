package week08.day1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * [연습 문제 3] 객체 검색
 * 문제: Student 객체들을 담은 ArrayList에서 이름이 "이순신"인 학생을 찾아 출력하세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        ArrayList<Student> students = new ArrayList<>();
        students.add( new Student("김철수"));
        students.add( new Student("안철수"));
        students.add( new Student("이순신"));
        students.add( new Student("홈길동"));

        for(Student s : students)
        {
            if(s.getName().equals("이순신"))
            {
                System.out.println("이순신 이름인 학생 확인");
            }
            else {
                System.out.println("이순신 이름인 학생 존재하지 않음");
            }
        }
    }

    static class Student
    {
        private String name;

        Student(String name) { this.name = name; }

        String getName() {return this.name; }
    }
}
