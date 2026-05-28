package week06.day4;

/**
 * [예습 파일] Week 06 Day 4 — 추상 클래스 (abstract)
 * 
 * [핵심 개념: 규격의 상속과 미완성 설계도]
 * 1. 추상 클래스(Abstract Class)의 성격:
 *    - `abstract` 키워드가 붙은 미완성 설계도로, 힙에 직접 독자적인 인스턴스(`new`)를 절대로 생성할 수 없습니다.
 *    - 오직 다른 자식 클래스들이 상속을 받아 완성하도록 구현 가이드를 잡아주는 역할(부모 역할)만 담당합니다.
 * 
 * 2. 추상 메서드 (Abstract Method):
 *    - 선언부만 있고 구현부(중괄호 `{ }`)가 아예 생략된 선언 메서드입니다.
 *    - 추상 클래스를 상속받는 일반(구체) 자식 클래스는 상속받은 부모의 추상 메서드들을 무조건 100% 강제로 오버라이딩하여 구현해야 하는 강력한 의무를 집니다. 만약 구현하지 않으면 자식 클래스마저 컴파일 에러를 겪습니다.
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
