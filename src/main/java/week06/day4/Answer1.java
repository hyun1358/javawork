package week06.day4;

public class Answer1 {
    public static void main(String[] args) {
        // 추상 클래스인 Shape 타입의 참조 변수로 자식 클래스인 Circle 객체를 가리킵니다. (다형성)
        Shape c = new Circle(5);
        
        // 부모의 추상 메서드를 호출하면, 자식 클래스에서 구현한 실제 메서드가 실행됩니다.
        System.out.println(c.area());
    }
}

// [클래스 설명] 추상 클래스: 하나 이상의 추상 메서드를 가지며, 객체를 직접 생성할 수 없는 불완전한 설계도입니다.
abstract class Shape {
    // [메서드 설명] 추상 메서드: 선언부만 있고 구현부({})가 없는 메서드입니다. 자식 클래스가 반드시 구현해야 합니다.
    abstract double area();
}

// [클래스 설명] 추상 클래스를 상속받은 자식 클래스는 부모의 모든 추상 메서드를 강제로 구현(오버라이딩)해야 합니다.
class Circle extends Shape {
    int r;

    Circle(int r) {
        this.r = r;
    }

    // [메서드 설명] 부모의 추상 메서드인 area()를 구체적으로 구현합니다.
    @Override
    double area() {
        return 3.14 * r * r;
    }
}
