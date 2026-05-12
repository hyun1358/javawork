package week06.day5;

/**
 * [예습 파일] Week 06 Day 5 — 인터페이스 (interface)
 */
public class Preview {
    public static void main(String[] args) {
        Flyable f = new Bird();
        f.fly();
    }
}

interface Flyable {
    void fly(); // public abstract 자동 생략
}

class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("새가 납니다.");
    }
}
