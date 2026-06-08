package week08.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * [학습 예제 5] Week 08 Day 3 — 객체의 정렬과 비교 Comparable/Comparator
 * 
 * [문제별 학습 목표]
 * - Lab5: 정렬 결과로부터 중복 등수를 고려한 Top 3 랭킹 추출 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab5: 정렬 결과로부터 중복 등수를 고려한 Top 3 랭킹 추출 (Problem 5 연계) ---");
        Lab5.run();
    }

    static class Student implements Comparable<Student> {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return o.score - this.score;
        }
    }

    static class Lab5 {
        static void run() {
            // Problem 5: Top 3 추출 (동점 등수 중복 처리)
            List<Student> students = new ArrayList<>();
            students.add(new Student("일길동", 50));
            students.add(new Student("이길동", 65));
            students.add(new Student("삼길동", 65)); // 65점 동점자
            students.add(new Student("사길동", 56));
            students.add(new Student("오길동", 64));
            students.add(new Student("육길동", 43));
            students.add(new Student("칠길동", 34));

            // 1. 점수 높은순 정렬
            Collections.sort(students);

            // 2. 동점 랭킹 순회 추출
            System.out.println("상위 3개 점수 대역 랭킹 추출 결과:");
            int rank = 0;
            int prevScore = -1;

            for (Student s : students) {
                // 이전 점수와 다를 때만 등수를 증가시킴으로써 공동 등수 처리 구현
                if (s.score != prevScore) {
                    rank++;
                }

                if (rank > 3) {
                    break; // 상위 3등 점수대까지만 출력
                }

                System.out.println(" - " + rank + "등: " + s.name + " (" + s.score + "점)");
                prevScore = s.score;
            }
        }
    }
}
