package week06.day2;

/**
 * [예습 파일] Week 06 Day 2 — 메서드 오버라이딩 (@Override)
 */
public class Preview {
    public static void main(String[] args) {
        Parent p = new Parent();
        Child c = new Child();
        p.print();
        c.print(); // 자식이 덮어쓴 메서드 호출
    }
}

class Parent {
    void print() {
        System.out.println("부모의 메서드");
    }
}

class Child extends Parent {
    @Override
    void print() {
        System.out.println("자식의 오버라이딩된 메서드");
    }
}
