package week06.day4;

public class Answer4 {
    public static void main(String[] args) {
        // 추상 클래스 참조 변수로 자식 객체를 다룹니다.
        Beverage b = new Tea();
        
        // 자식 클래스에서 구현된 메서드가 실행됩니다.
        b.brew();
        // 부모 클래스에 미리 정의된 공통 메서드가 실행됩니다.
        b.serve();
    }
}

// [클래스 설명] 음료 제조 과정을 모델링한 추상 클래스입니다.
abstract class Beverage {
    // [메서드 설명] 음료마다 우려내는 방식이 다르므로 자식에게 구현을 강제합니다.
    abstract void brew();

    // [메서드 설명] 제공하는 방식은 모든 음료가 동일하므로 기본 기능을 미리 제공합니다.
    void serve() {
        System.out.println("제공");
    }
}

// [클래스 설명] Beverage를 상속받아 차를 만드는 클래스입니다.
class Tea extends Beverage {
    // [메서드 설명] 차의 특성에 맞게 우리는 방식을 구체적으로 구현합니다.
    @Override
    void brew() {
        System.out.println("차 우려내기");
    }
}
