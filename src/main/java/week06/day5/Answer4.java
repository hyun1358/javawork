package week06.day5;

public class Answer4 {
    public static void main(String[] args) {
        // Machine 인터페이스 타입으로 PC 객체를 다룹니다.
        Machine m = new PC();
        
        // PC 클래스에서 직접 구현한 켜기 메서드입니다.
        m.on();
        
        // PC 클래스에서 구현하지 않았지만, 인터페이스가 기본으로 제공하는 디폴트 메서드를 사용할 수 있습니다.
        m.off(); // default
    }
}

// [인터페이스 설명] 기계의 기본적인 전원 제어 기능을 정의한 인터페이스입니다.
interface Machine {
    // [메서드 설명] 기계마다 켜지는 방식이 다를 수 있으므로 추상 메서드로 선언합니다.
    void on();

    // [메서드 설명] Java 8부터 추가된 default 메서드 기능입니다.
    // 인터페이스 내부에서도 공통된 로직을 가진 메서드의 구현부를 가질 수 있게 해줍니다.
    default void off() {
        System.out.println("전원 끄기 기본 동작");
    }
}

// [클래스 설명] Machine 인터페이스를 구현하는 개인용 컴퓨터 클래스입니다.
class PC implements Machine {
    // [메서드 설명] 추상 메서드인 on()만 필수로 구현하면 됩니다. 
    // off()는 디폴트 구현이 있으므로 생략해도 됩니다. (원한다면 오버라이딩 가능)
    public void on() {
        System.out.println("PC 켜기");
    }
}
