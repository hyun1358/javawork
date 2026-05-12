package week08.day1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * [학습 예제] Week 08 Day 1 — ArrayList 활용
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: 리스트 순회 ===");
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(10, 20, 30));
        for (int n : nums) {
            System.out.print(n + " ");
        }

        System.out.println("\n=== Lab2: 객체 리스트 ===");
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("홍길동"));
        students.add(new Student("이순신"));
        System.out.println("첫번째 학생: " + students.get(0).name);
    }
}

class Student {
    String name;

    Student(String n) {
        name = n;
    }
}
