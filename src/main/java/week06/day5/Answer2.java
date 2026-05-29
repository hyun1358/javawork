package week06.day5;

public class Answer2 {
    public static void main(String[] args) {
        // 오리 객체를 생성합니다.
        DuckAns d = new DuckAns();
        
        // 오리는 Flyable2와 Swimable 두 인터페이스를 모두 구현했으므로,
        // 두 가지 기능을 모두 사용할 수 있습니다.
        d.fly();
        d.swim();
    }
}

// [인터페이스 설명] 수영 가능한 기능을 정의한 인터페이스입니다.
interface Swimable {
    void swim();
}

// [인터페이스 설명] 비행 가능한 기능을 정의한 인터페이스입니다.
interface Flyable2 {
    void fly();
}

// [클래스 설명] 클래스는 다중 상속이 안 되지만, 인터페이스는 콤마(,)를 사용해 다중 구현이 가능합니다.
// 오리는 수영도 하고 날 수도 있으므로 두 인터페이스를 동시에 구현합니다.
class DuckAns implements Swimable, Flyable2 {
    // [메서드 설명] Flyable2 인터페이스의 요구사항을 구현합니다.
    public void fly() {
        System.out.println("날기");
    }

    // [메서드 설명] Swimable 인터페이스의 요구사항을 구현합니다.
    public void swim() {
        System.out.println("수영");
    }
}
