package week11.day2;

import java.util.Arrays;
import java.util.Collections;

// 보충 문제 1_1의 모범 정답 파일입니다.
public class Answer1_1 {
    public static void main(String[] args) {
        Student[] students = {
            new Student("홍길동", 85),
            new Student("이순신", 95),
            new Student("강감찬", 70),
            new Student("임꺽정", 80)
        };

        Sorter<Student> sorter = new Sorter<>();

        System.out.println("--- 정렬 전 ---");
        printStudents(students);

        // 1. 오름차순 정렬 전략 주입 (람다식으로 구현)
        sorter.setStrategy(arr -> Arrays.sort(arr));
        sorter.sort(students);
        System.out.println("\n--- 오름차순 정렬 후 ---");
        printStudents(students);

        // 2. 내림차순 정렬 전략 주입 (람다식으로 구현)
        sorter.setStrategy(arr -> Arrays.sort(arr, Collections.reverseOrder()));
        sorter.sort(students);
        System.out.println("\n--- 내림차순 정렬 후 ---");
        printStudents(students);
    }

    private static void printStudents(Student[] students) {
        for (Student s : students) {
            System.out.println(s);
        }
    }

    interface SortStrategy<T extends Comparable<T>> {
        void sort(T[] arr);
    }

    static class Sorter<T extends Comparable<T>> {
        private SortStrategy<T> strategy;

        public void setStrategy(SortStrategy<T> s) {
            this.strategy = s;
        }

        public void sort(T[] arr) {
            if (strategy != null) {
                strategy.sort(arr);
            }
        }
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
            // 오름차순 비교 로직: 점수 기준
            return this.score - o.score;
        }

        @Override
        public String toString() {
            return name + " (" + score + "점)";
        }
    }
}
