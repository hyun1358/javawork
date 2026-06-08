package week05.day1;

/**
 * [학습 예제 5] Week 05 Day 1 — 클래스와 객체의 기초
 * 
 * [학습 핵심 이론: 객체지향 프로그래밍(OOP) 기초]
 * 3. 객체 배열 (Object Array):
 *    - 객체 배열은 객체 자체가 직접 들어가는 것이 아니라, 객체가 생성된 힙(Heap) 주소를 가리키는 '참조값'들이 배열의 각 칸에 들어가는 배열 구조입니다.
 * 
 * [문제별 학습 목표]
 * - Lab5: 객체 배열(Student Array)의 선언 및 일괄 제어 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        // Student 객체 배열 생성 및 반복 제어
        Student[] students = new Student[3];
        students[0] = new Student("홍길동", 85);
        students[1] = new Student("김철수", 92);
        students[2] = new Student("김영희", 78);

        System.out.println("--- 학생 명단 및 점수 ---");
        for (Student s : students) {
            System.out.println("이름: " + s.name + ", 점수: " + s.score);
        }
    }

    // Problem 5 연계 Student 클래스 정의
    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
