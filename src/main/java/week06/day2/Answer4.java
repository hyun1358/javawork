package week06.day2;

public class Answer4 {
    public static void main(String[] args) {
        // SmartPhone 객체를 생성합니다.
        SmartPhone p = new SmartPhone();
        
        // 오버라이딩된 call() 메서드를 실행하여 부모의 기능과 확장된 기능이 모두 실행되는지 확인합니다.
        p.call();
    }
}

// [클래스 설명] 기본적인 전화 기능을 제공하는 부모 클래스입니다.
class Phone {
    // [메서드 설명] 통화를 수행하는 기본 동작입니다.
    void call() {
        System.out.println("전화 걸기");
    }
}

// [클래스 설명] Phone을 상속받아 기존 기능에 새로운 기능을 추가(확장)하는 자식 클래스입니다.
class SmartPhone extends Phone {
    // [메서드 설명] 부모의 메서드를 완전히 덮어쓰지 않고, 기존 로직을 재사용하면서 기능을 덧붙입니다.
    @Override
    void call() {
        // [핵심 로직] super 키워드를 사용하여 부모의 원래 call() 메서드를 먼저 호출합니다.
        super.call();
        // 이후 자식 클래스만의 추가적인 기능을 실행합니다.
        System.out.println("인터넷 검색도 가능");
    }
}
