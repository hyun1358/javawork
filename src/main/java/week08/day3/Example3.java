package week08.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * [학습 예제 3] Week 08 Day 3 — 객체의 정렬과 비교 Comparable/Comparator
 * 
 * [학습 핵심 이론: 자바의 정렬 메커니즘]
 * 2. Comparator 인터페이스 (대체 정렬 기준 - Custom Ordering):
 *    - 클래스 자체를 변경하지 않고 임시 정렬 기준(예: 이름 사전순, 보조 정렬 등)을 외부에서 동적으로 부여할 때 사용합니다.
 *    - `compare(T o1, T o2)`를 오버라이딩합니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: Comparator를 활용한 Student 이름 사전순 정렬 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab3: Comparator를 활용한 Student 이름 사전순 정렬 (Problem 3 연계) ---");
        Lab3.run();
    }

    static class StudentDetail {
        String name;
        int age;
        int score;

        StudentDetail(String name, int age, int score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }
    }

    static class Lab3 {
        static void run() {
            // Problem 3: Comparator 구현 (이름순)
            List<StudentDetail> students = new ArrayList<>();
            students.add(new StudentDetail("이길동", 20, 50));
            students.add(new StudentDetail("일길동", 22, 40));
            students.add(new StudentDetail("사길동", 19, 70));
            students.add(new StudentDetail("삼길동", 21, 60));

            // StudentDetail은 Comparable이 없으나 외부 Comparator로 이름 사전순 정렬 부여
            Collections.sort(students, new Comparator<StudentDetail>() {
                @Override
                public int compare(StudentDetail o1, StudentDetail o2) {
                    return o1.name.compareTo(o2.name); // String 사전순 비교 활용
                }
            });

            System.out.println("이름 사전순 정렬 학생 목록:");
            for (StudentDetail s : students) {
                System.out.printf(" - 이름: %s | 나이: %d\n", s.name, s.age);
            }
        }
    }
}
