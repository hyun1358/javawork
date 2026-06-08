package week08.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * [학습 예제 4] Week 08 Day 3 — 객체의 정렬과 비교 Comparable/Comparator
 * 
 * [학습 핵심 이론: 자바의 정렬 메커니즘]
 * 3. 다중 정렬 조건 (Multi-criteria Sorting):
 *    - 1차 정렬 기준이 동일할 때, 2차 정렬 조건(예: 이름이 같으면 나이순)을 적용하여 정밀하게 배열/리스트를 배치합니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: 이름이 같을 때 나이순으로 정렬하는 다중 조건 정렬 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab4: 이름이 같을 때 나이순으로 정렬하는 다중 조건 정렬 (Problem 4 연계) ---");
        Lab4.run();
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

    static class Lab4 {
        static void run() {
            // Problem 4: 다중 기준 정렬
            List<StudentDetail> students = new ArrayList<>();
            students.add(new StudentDetail("일길동", 40, 80));
            students.add(new StudentDetail("이길동", 50, 95));
            students.add(new StudentDetail("이길동", 30, 85)); // 이름 같음, 나이 다름
            students.add(new StudentDetail("사길동", 70, 70));

            // 정렬 조건: 이름이 같으면 나이순(오름차순), 다르면 이름 사전순
            Collections.sort(students, new Comparator<StudentDetail>() {
                @Override
                public int compare(StudentDetail o1, StudentDetail o2) {
                    if (o1.name.equals(o2.name)) {
                        return o1.age - o2.age; // 나이 오름차순
                    }
                    return o1.name.compareTo(o2.name); // 이름 사전순
                }
            });

            System.out.println("다중 조건(이름순 -> 나이순) 정렬 결과:");
            for (StudentDetail s : students) {
                System.out.printf(" - 이름: %s | 나이: %d\n", s.name, s.age);
            }
        }
    }
}
