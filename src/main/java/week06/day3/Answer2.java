package week06.day3;

public class Answer2 {
    public static void main(String[] args) {
        // 부모 클래스(Item) 타입의 참조 변수에 자식 클래스(Computer)의 객체를 연결합니다. (업캐스팅)
        Item item = new Computer();
        
        // 부모 타입 변수로 메서드를 호출하더라도, 실제 생성된 객체(Computer)에 오버라이딩된 메서드가 우선적으로 실행됩니다. (동적 바인딩)
        item.print(); // Computer의 print()가 호출됨
    }
}

// [클래스 설명] 기본 아이템을 나타내는 부모 클래스입니다.
class Item {
    // [메서드 설명] 부모 클래스의 기본 출력 메서드입니다.
    void print() {
        System.out.println("아이템");
    }
}

// [클래스 설명] Item을 상속받은 자식 클래스입니다.
class Computer extends Item {
    // [메서드 설명] 부모의 print() 메서드를 재정의하여 컴퓨터만의 출력을 정의합니다.
    @Override
    void print() {
        System.out.println("컴퓨터");
    }
}
