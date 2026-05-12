package week06.day4;

/**
 * [예습 파일] Week 06 Day 4 — 추상 클래스 (abstract)
 */
public class Preview {
    public static void main(String[] args) {
        // Animal a = new Animal(); // 추상 클래스는 직접 객체 생성 불가
        Dog d = new Dog();
        d.sound();
        d.sleep(); // 공통 메서드 그대로 사용
    }
}

abstract class Animal {
    abstract void sound(); // 자식이 무조건 구현해야 함

    void sleep() {
        System.out.println("쿨쿨...");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("멍멍");
    }
}
