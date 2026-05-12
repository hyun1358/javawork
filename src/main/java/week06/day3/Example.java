package week06.day3;

/**
 * [학습 예제] Week 06 Day 3 — 다형성 배열과 다운캐스팅
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: 다형성 배열 ===");
        Animal[] zoo = {new Dog(), new Cat()};
        for (Animal a : zoo) {
            a.sound();
        }

        System.out.println("\n=== Lab2: 다운캐스팅과 instanceof ===");
        for (Animal a : zoo) {
            if (a instanceof Dog) {
                Dog d = (Dog) a; // 다운캐스팅
                d.guard(); // Dog 전용 메서드
            }
        }
    }
}

class Animal {
    void sound() {
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("멍멍");
    }

    void guard() {
        System.out.println("집지키기");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("야옹");
    }
}
