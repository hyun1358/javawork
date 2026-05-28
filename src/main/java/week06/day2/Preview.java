package week06.day2;

/**
 * [예습 파일] Week 06 Day 2 — 메서드 오버라이딩 (@Override)
 * 
 * [핵심 개념: 부모의 동작을 내 식대로 덮어쓰기]
 * 1. 메서드 오버라이딩(Method Overriding):
 *    - 부모 클래스로부터 물려받은 메서드와 완전히 똑같은 시그니처(이름, 반환타입, 매개변수 목록)를 가진 메서드를 자식 클래스 내부에 재정의하여 기능을 덮어쓰는 OOP의 정수입니다.
 * 
 * 2. 오버라이딩의 필수 3대 규칙:
 *    - 메서드 시그니처가 부모의 것과 100% 동일해야 합니다.
 *    - 부모 메서드보다 좁은 범위의 접근 제어자로 변경할 수 없습니다. (예: 부모가 protected면 자식은 private 불가능, public만 가능)
 *    - 부모 메서드가 선언한 예외보다 더 넓은 범위의 예외(Checked Exception)를 던질 수 없습니다.
 * 
 * 3. @Override 어노테이션의 신뢰성:
 *    - 컴파일러에게 "이 메서드는 상위 메서드를 오버라이딩했다"고 명시하여, 단순 이름 오타 등으로 인한 오작동을 컴파일 시점에 완벽히 에러로 색출해 줍니다.
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
