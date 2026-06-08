package week08.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * [학습 예제 2] Week 08 Day 3 — 객체의 정렬과 비교 Comparable/Comparator
 * 
 * [학습 핵심 이론: 자바의 정렬 메커니즘]
 * 1. Comparable 인터페이스 (자연스러운 정렬 - Natural Ordering):
 *    - 클래스의 주 정렬 기준을 클래스 내부에 확정하고자 할 때 구현합니다 (`implements Comparable<T>`).
 *    - `compareTo(T o)`를 오버라이딩합니다:
 *      - 오름차순: `this.value - o.value` (나 - 상대방)
 *      - 내림차순: `o.value - this.value` (상대방 - 나)
 * 
 * [문제별 학습 목표]
 * - Lab2: Comparable을 구현한 Student 객체의 점수 정렬 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab2: Comparable을 구현한 Student 객체의 점수 정렬 (Problem 2 연계) ---");
        Lab2.run();
    }

    // Problem 2: Comparable을 구현하여 점수 내림차순 정렬이 가능한 Student 클래스
    static class Student implements Comparable<Student> {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            // 점수 내림차순(높은 순) 정렬: 상대방 - 나
            return o.score - this.score;
        }
    }

    static class Lab2 {
        static void run() {
            // Problem 2: Comparable 구현
            List<Student> students = new ArrayList<>();
            students.add(new Student("일길동", 50));
            students.add(new Student("이길동", 80));
            students.add(new Student("삼길동", 60));
            students.add(new Student("사길동", 70));

            // Student 내부의 compareTo()에 의해 점수 내림차순 정렬됨
            Collections.sort(students);

            System.out.println("점수 내림차순(높은 순) 정렬 학생 목록:");
            for (Student s : students) {
                System.out.printf(" - 이름: %s | 점수: %d\n", s.name, s.score);
            }
        }
    }
}
