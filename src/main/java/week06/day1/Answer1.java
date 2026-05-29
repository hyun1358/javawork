package week06.day1;

public class Answer1 {
    public static void main(String[] args) {
        // DogAns 객체를 생성합니다. 이 객체는 AnimalAns를 상속받아 name 필드를 가지고 있습니다.
        DogAns d = new DogAns();
        d.name = "멍멍이"; // 부모로부터 물려받은 필드에 값 할당
        d.bark(); // 자신만의 메서 호출

        // CatAns 객체를 생성합니다. 역시 AnimalAns를 상속받았습니다.
        CatAns c = new CatAns();
        c.name = "야옹이"; // 부모로부터 물려받은 필드에 값 할당
        c.meow(); // 자신만의 메서드 호출
    }
}

// [클래스 설명] AnimalAns는 동물의 공통 속성을 정의하는 부모 클래스(슈퍼 클래스)입니다.
class AnimalAns {
    // 모든 동물이 공통으로 가지는 이름 속성입니다.
    String name;
}

// [클래스 설명] DogAns는 AnimalAns를 상속(extends)받아 부모의 name 필드를 재사용하며 짖는 기능을 추가합니다.
class DogAns extends AnimalAns {
    // [메서드 설명] 강아지만의 특화된 동작(메서드)입니다.
    void bark() {
        System.out.println(name + ": 멍멍");
    }
}

// [클래스 설명] CatAns는 AnimalAns를 상속받아 부모의 name 필드를 재사용하며 고양이 고유의 기능을 추가합니다.
class CatAns extends AnimalAns {
    // [메서드 설명] 고양이만의 특화된 동작(메서드)입니다.
    void meow() {
        System.out.println(name + ": 야옹");
    }
}
