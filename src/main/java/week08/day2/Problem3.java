package week08.day2;

import java.util.HashMap;

/**
 * [연습 문제 3] 학생 객체 매핑
 * 문제: 학번(Integer)을 키로, Student 객체를 값으로 저장하고 조회하세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        HashMap<Integer, Student> students = new HashMap<>();
        students.put(20260519,new Student("홍길동",70));
        students.put(20260518,new Student("세종",98));

        for(Integer key : students.keySet())
        {
            Student s = students.get(key);
            System.out.printf("학번: %d, 이름: %s, 점수: %d\n",key,s.name,s.score);
        }
    }

    static class Student
    {
        public String name;
        public int score;

        Student(String name, int score)
        {
            this.name = name;
            this.score=score;
        }
    }
}
