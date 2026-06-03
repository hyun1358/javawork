package week10.day5;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * [실습 1] 객체 직렬화 — 파일에 저장 (Problem 1 연계)
 * 
 * 비유: "내 아바타(객체)를 냉동 보존하기 위해 바이트 스트림으로 얼려서 창고(.dat)에 넣기"
 * 메모리상의 자바 객체 데이터를 파일에 영구 저장하기 위해, ObjectOutputStream을 이용하여 
 * 객체를 쪼개어 바이트 스트림으로 변환(직렬화)하는 정석 방법을 학습합니다.
 */
public class Example1 {
    // 직렬화를 가능하게 하려면 반드시 java.io.Serializable 인터페이스를 구현해야 합니다.
    static class Student implements Serializable {
        String name;
        int score;
        transient String password; // transient -> 직렬화 대상에서 제외

        Student(String name, int score, String password) {
            this.name = name;
            this.score = score;
            this.password = password;
        }

        @Override
        public String toString() {
            return "Student{name=" + name + ", score=" + score + ", password=" + password + "}";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== [실습 1] 객체 직렬화 (파일에 저장) 예제 ===");
        Student s1 = new Student("홍길동", 95, "secret123");

        // ObjectOutputStream을 열어 객체를 바이트로 직렬화하여 디스크에 저장합니다.
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.dat"))) {
            oos.writeObject(s1);
            System.out.println("-> 객체 직렬화 저장 성공: " + s1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
