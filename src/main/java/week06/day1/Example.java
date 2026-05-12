package week06.day1;

/**
 * [학습 예제] Week 06 Day 1 — 상속과 super
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: 자식 생성자에서 super() ===");
        Child c = new Child("홍길동", 20);
        c.show();
    }
}

class Parent {
    String name;

    Parent(String name) {
        this.name = name;
    }
}

class Child extends Parent {
    int age;

    Child(String name, int age) {
        super(name); // 부모 생성자 명시적 호출
        this.age = age;
    }

    void show() {
        System.out.println("이름: " + name + ", 나이: " + age);
    }
}
