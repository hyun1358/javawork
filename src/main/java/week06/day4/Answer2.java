package week06.day4;

public class Answer2 {
    public static void main(String[] args) {
        // 추상 클래스 타입으로 자식 객체를 참조합니다.
        AnimalAns a = new DogAns();
        
        // 자식 클래스에서 필수로 구현한 추상 메서드가 호출됩니다.
        a.sound();
        // 부모 클래스에 구현되어 상속받은 일반 메서드도 정상적으로 호출됩니다.
        a.breathe();
    }
}

// [클래스 설명] 추상 메서드와 일반 메서드를 모두 가질 수 있는 추상 클래스의 특징을 보여줍니다.
abstract class AnimalAns {
    // [메서드 설명] 동물마다 내는 소리가 다르므로, 자식 클래스에서 구현하도록 추상 메서드로 남겨둡니다.
    abstract void sound();

    // [메서드 설명] 모든 동물이 공통으로 하는 호흡은 부모 클래스에서 일반 메서드로 미리 구현해둡니다.
    void breathe() {
        System.out.println("호흡");
    }
}

// [클래스 설명] AnimalAns를 상속받은 강아지 클래스입니다.
class DogAns extends AnimalAns {
    // [메서드 설명] 미완성된 sound() 메서드만 구현하면 되고, breathe()는 그대로 상속받아 사용합니다.
    @Override
    void sound() {
        System.out.println("멍멍");
    }
}
