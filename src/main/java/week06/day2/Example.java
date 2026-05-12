package week06.day2;

/**
 * [학습 예제] Week 06 Day 2 — Object 클래스의 오버라이딩
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: toString 오버라이딩 ===");
        Student s = new Student("홍길동", 20);
        System.out.println(s); // toString 자동 호출
    }
}

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}
