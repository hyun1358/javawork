package week06.day5;

public class Answer1 {
    public static void main(String[] args) {
        // 인터페이스 타입의 참조 변수로, 이를 구현한 새(BirdAns) 객체를 다룹니다. (다형성)
        FlyableAns b = new BirdAns();
        b.fly(); // 새의 비행 동작 실행

        // 동일한 인터페이스 타입으로, 비행기(Airplane) 객체도 다룰 수 있습니다.
        FlyableAns a = new Airplane();
        a.fly(); // 비행기의 비행 동작 실행
    }
}

// [인터페이스 설명] 비행 가능한(Flyable) 객체들이 반드시 가져야 할 동작을 규격화합니다.
interface FlyableAns {
    // [메서드 설명] 인터페이스의 메서드는 기본적으로 public abstract입니다. 구현부가 없습니다.
    void fly();
}

// [클래스 설명] 생물인 새가 비행 기능을 갖추도록 인터페이스를 구현(implements)합니다.
class BirdAns implements FlyableAns {
    // [메서드 설명] 인터페이스의 추상 메서드를 반드시 public으로 구현해야 합니다.
    public void fly() {
        System.out.println("새 날다");
    }
}

// [클래스 설명] 무생물인 기계가 비행 기능을 갖추도록 인터페이스를 구현합니다.
// 서로 관련이 없는 BirdAns와 Airplane도 FlyableAns라는 공통의 규격을 가질 수 있습니다.
class Airplane implements FlyableAns {
    // [메서드 설명] 기계에 맞는 비행 방식을 구현합니다.
    public void fly() {
        System.out.println("비행기 날다");
    }
}
