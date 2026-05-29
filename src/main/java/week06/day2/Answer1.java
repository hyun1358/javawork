package week06.day2;

public class Answer1 {
    public static void main(String[] args) {
        // DogAns 객체를 생성하고 오버라이딩된 sound() 메서드를 호출합니다.
        DogAns d = new DogAns();
        d.sound(); // "멍멍" 출력
        
        // CatAns 객체를 생성하고 오버라이딩된 sound() 메서드를 호출합니다.
        CatAns c = new CatAns();
        c.sound(); // "야옹" 출력
    }
}

// [클래스 설명] 동물의 기본 소리를 정의하는 부모 클래스입니다.
class AnimalAns {
    // [메서드 설명] 모든 동물의 기본이 되는 소리를 출력합니다. 자식 클래스에서 재정의될 수 있습니다.
    void sound() {
        System.out.println("동물 소리");
    }
}

// [클래스 설명] AnimalAns를 상속받아 강아지의 소리로 메서드를 재정의한 자식 클래스입니다.
class DogAns extends AnimalAns {
    // [메서드 설명] @Override 어노테이션을 사용하여 부모의 sound() 메서드를 강아지에 맞게 재정의(Overriding)합니다.
    @Override
    void sound() {
        System.out.println("멍멍");
    }
}

// [클래스 설명] AnimalAns를 상속받아 고양이의 소리로 메서드를 재정의한 자식 클래스입니다.
class CatAns extends AnimalAns {
    // [메서드 설명] 부모의 메서드를 고양이에 맞게 재정의합니다.
    @Override
    void sound() {
        System.out.println("야옹");
    }
}
