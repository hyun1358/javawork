package week08.day1;

import java.util.ArrayList;

/**
 * [학습 예제 3] Week 08 Day 1 — 자료구조 컬렉션 ArrayList 기초
 * 
 * [문제별 학습 목표]
 * - Lab3: Student 객체 리스트 특정 이름 검색 필터 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab3: Student 객체 리스트 특정 이름 검색 필터 (Problem 3 연계) ---");
        Lab3.run();
    }

    // Problem 3 연계 Student 클래스 정의
    static class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() { return name; }
    }

    static class Lab3 {
        static void run() {
            // Problem 3: 객체 검색
            ArrayList<Student> students = new ArrayList<>();
            students.add(new Student("김철수"));
            students.add(new Student("안철수"));
            students.add(new Student("이순신"));
            students.add(new Student("홍길동"));

            String targetName = "이순신";
            boolean found = false;

            for (Student s : students) {
                if (s.getName().equals(targetName)) {
                    System.out.println("학생 검색 성공: \"" + s.getName() + "\" 학생이 리스트에 존재합니다.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("검색 실패: \"" + targetName + "\" 학생이 없습니다.");
            }
        }
    }
}
