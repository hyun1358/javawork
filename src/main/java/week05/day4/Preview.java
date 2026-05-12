package week05.day4;

/**
 * [예습 파일] Week 05 Day 4 — static (공유 변수와 메서드)
 */
public class Preview {
    public static void main(String[] args) {
        // 1. static 변수 접근 (객체 생성 없이 가능)
        System.out.println("현재 학생 수: " + Student.count);

        Student s1 = new Student("홍길동");
        Student s2 = new Student("이순신");

        System.out.println("학생 추가 후 수: " + Student.count);

        // 2. static 메서드 호출 (Math 클래스처럼 사용)
        int result = Calculator.add(10, 20);
        System.out.println("계산 결과: " + result);
    }
}

class Student {
    static int count = 0; // 모든 학생 객체가 공유하는 변수
    String name;

    Student(String name) {
        this.name = name;
        count++; // 학생이 생성될 때마다 카운트 증가
    }
}

class Calculator {
    static int add(int a, int b) {
        return a + b;
    }
}
