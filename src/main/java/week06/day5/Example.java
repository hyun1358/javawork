package week06.day5;

/**
 * [학습 예제] Week 06 Day 5 — 다중 구현과 default 메서드
 */
public class Example {
    public static void main(String[] args) {
        Duck d = new Duck();
        d.fly();
        d.swim();
        d.rest(); // default 메서드
    }
}

interface Fly {
    void fly();
}

interface Swim {
    void swim();

    default void rest() {
        System.out.println("물 위에서 휴식 (default)");
    }
}

class Duck implements Fly, Swim {
    @Override
    public void fly() {
        System.out.println("오리 날다");
    }

    @Override
    public void swim() {
        System.out.println("오리 수영하다");
    }
}
