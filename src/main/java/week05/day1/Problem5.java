package week05.day1;

import java.util.Random;

import javax.security.auth.Subject;

/**
 * [연습 문제 5] Week 05 Day 1
 * <p>
 * 문제: 여러 명의 학생 정보를 배열에 담아 출력하세요.
 * 1. Student 클래스(이름, 점수)를 만듭니다.
 * 2. Student 객체 3개를 담을 수 있는 배열을 만듭니다.
 * 3. for문을 이용해 배열에 담긴 학생들의 이름과 점수를 출력하세요.
 * <p>
 * 난이도: ★★★☆☆
 */
public class Problem5 {
    public static void main(String[] args) {
        // TODO: Student 객체 3개를 생성하여 배열에 넣고 반복문으로 정보를 출력하세요.
        Student[] studnet = new Student[3];

        String[] strName = {"홍길동", "김철수", "김영희"};

        for (int i = 0; i < 3; i++) {
            studnet[i] = new Student(strName[i], (int) (Math.random() * 100) + 1);
        }

        for (Student s : studnet)
            System.out.println("이름 : " + s.name + ", 점수: " + s.score);

    }

    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
