package week11.day2;

import java.util.Arrays;
import java.util.Collections;

/**
 * [보충 문제 1_1] 제네릭을 활용한 객체 정렬 전략 패턴
 * 
 * 문제:
 * 학생(Student)들의 점수(score)를 기준으로 오름차순/내림차순 정렬을 수행하는 제네릭 정렬기를 만드세요.
 * 제네릭 타입 파라미터 <T extends Comparable<T>>를 사용하는 SortStrategy 인터페이스와
 * 이를 주입받아 동작하는 Sorter 클래스를 작성해 봅니다.
 * 
 * 조건:
 * 1. Student 클래스는 score를 기준으로 정렬 가능하도록 Comparable<Student>를 구현해야 합니다.
 * 2. 람다식 또는 구체 클래스 구현법 중 원하는 방식으로 오름차순 및 내림차순 정렬 전략을 주입하여 테스트하세요.
 */
public class Problem1_1 {
    public static void main(String[] args)
    {
        Student[] students =
                {
            new Student("홍길동", 85),
            new Student("이순신", 95),
            new Student("강감찬", 70),
            new Student("임꺽정", 80)
        };

        Sorter<Student> sorter = new Sorter<>();

        System.out.println("--- 정렬 전 ---");
        printStudents(students);

        // TODO 1: 오름차순 정렬 전략을 주입하고 정렬한 결과를 출력하세요.
        sorter.setStrategy(student-> Arrays.sort(students));
        sorter.sort(students);
        System.out.println("\n--- 오름차순 정렬 후 ---");
        printStudents(students);

        // TODO 2: 내림차순 정렬 전략을 주입하고 정렬한 결과를 출력하세요.
        sorter.setStrategy(student-> Arrays.sort(students, Collections.reverseOrder()));
        sorter.sort(students);
        System.out.println("\n--- 내림차순 정렬 후 ---");
        printStudents(students);
    }

    private static void printStudents(Student[] students) {
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // 제네릭 정렬 전략 인터페이스
    interface SortStrategy<T extends Comparable<T>> {
        void sort(T[] arr);
    }

    // Context 클래스
    static class Sorter<T extends Comparable<T>>
    {
        private SortStrategy<T> strategy;

        public void setStrategy(SortStrategy<T> s) {
            this.strategy = s;
        }

        public void sort(T[] arr)
        {
            // TODO: 주입받은 전략을 호출하여 정렬을 수행하세요.
            strategy.sort(arr);
        }
    }

    // 정렬 대상 객체 Student
    static class Student implements Comparable<Student>
    {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Student o)
        {
            // TODO: 점수(score)를 기준으로 오름차순 비교 로직을 완성하세요.
            return this.score - o.score;
        }

        @Override
        public String toString() {
            return name + " (" + score + "점)";
        }
    }
}
