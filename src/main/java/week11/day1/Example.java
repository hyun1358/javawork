package week11.day1;

/**
 * [학습 예제] Week 11 Day 1 — 팩토리 메서드 패턴
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab: 팩토리를 통한 객체 생성 ===");
        // 직접 new Animal()을 하지 않고 팩토리에게 맡깁니다.
        Animal a1 = AnimalFactory.create("DOG");
        Animal a2 = AnimalFactory.create("CAT");

        a1.speak();
        a2.speak();
    }
}

interface Animal {
    void speak();
}

class Dog implements Animal {
    public void speak() {
        System.out.println("멍멍");
    }
}

class Cat implements Animal {
    public void speak() {
        System.out.println("야옹");
    }
}

class AnimalFactory {
    // 문자열에 따라 적절한 객체를 대신 생성해주는 팩토리
    public static Animal create(String type) {
        if (type.equalsIgnoreCase("DOG")) return new Dog();
        if (type.equalsIgnoreCase("CAT")) return new Cat();
        throw new IllegalArgumentException("알 수 없는 동물 타입");
    }
}
