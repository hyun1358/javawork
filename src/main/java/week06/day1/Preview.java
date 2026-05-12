package week06.day1;

/**
 * [예습 파일] Week 06 Day 1 — 상속 기초 (extends)
 */
public class Preview {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "바둑이"; // 부모 필드 상속
        dog.sound();       // 자식 메서드 호출
        dog.eat();         // 부모 메서드 호출
    }
}

class Animal {
    String name;

    void eat() {
        System.out.println(name + "가 밥을 먹습니다.");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("멍멍!");
    }
}
