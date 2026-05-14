package week08.day1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * [학습 예제] Week 08 Day 1 — ArrayList 활용
 * 
 * [참고: 왜 int가 아니라 Integer인가요?]
 * 제네릭 < > 안에는 int 같은 기본형을 쓸 수 없어 객체 형태인 Integer를 씁니다.
 * 
 * [ArrayList 활용 팁]
 * 1. 데이터를 하나씩 넣을 때는 .add()
 * 2. 여러 개를 한꺼번에 넣고 시작할 때는 Arrays.asList()를 활용합니다.
 * 3. 향상된 for문(for-each)을 사용하면 리스트 순회가 매우 간편합니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: 리스트 순회 ===");
        // 초기 데이터를 가진 리스트 생성
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(10, 20, 30));
        
        // 리스트의 데이터를 하나씩 꺼내 n에 담아 출력합니다.
        for (int n : nums) {
            System.out.print(n + " ");
        }

        System.out.println("\n=== Lab2: 객체 리스트 ===");
        // 우리가 만든 클래스(Student)도 리스트에 담을 수 있습니다!
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("홍길동"));
        students.add(new Student("이순신"));
        
        // 꺼내올 때: .get(index).필드명
        System.out.println("첫번째 학생: " + students.get(0).name);
    }
}

class Student {
    String name;

    Student(String n) {
        name = n;
    }
}
