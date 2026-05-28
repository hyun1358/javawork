package week06.day3;

/**
 * [예습 파일] Week 06 Day 3 — 다형성 (Polymorphism)
 * 
 * [핵심 개념: 한 객체의 다양한 모습]
 * 1. 다형성(Polymorphism)의 대전제:
 *    - 부모(조상) 타입의 참조 변수로 자식(자손) 타입의 실제 인스턴스 객체를 참조할 수 있도록 허용하는 자바 객체지향의 가장 강력한 디자인 패턴 구조입니다.
 *    - 예: `Animal ani = new Dog();`
 * 
 * 2. 접근 가능 멤버의 제약:
 *    - 부모 참조 타입으로 자식 객체를 제어하는 경우, 비록 힙 메모리에 자식 전용 필드가 생성되어 있어도 부모 클래스 내에 원래 정의되어 있던 멤버들에만 접근할 수 있습니다.
 * 
 * 3. 오버라이딩 메서드의 동적 바인딩 (Dynamic Binding):
 *    - 부모 타입으로 메서드를 호출하더라도, 그 메서드가 자식 클래스에서 '오버라이딩(Overriding)'되어 있다면, 컴파일러는 무조건 힙 메모리에 살아 있는 자식의 실제 재정의 메서드를 최우선으로 실행시킵니다.
 */
public class Preview {
    public static void main(String[] args) {
        // 업캐스팅 (자식 객체를 부모 타입 변수에 담기)
        AnimalPreview a1 = new DogPreview();
        AnimalPreview a2 = new CatPreview();

        a1.sound(); // 실제 생성된 객체(Dog)의 메서드 실행 (동적 바인딩)
        a2.sound(); // Cat의 메서드 실행
    }
}

class AnimalPreview {
    void sound() {
        System.out.println("동물");
    }
}

class DogPreview extends AnimalPreview {
    @Override
    void sound() {
        System.out.println("멍멍");
    }
}

class CatPreview extends AnimalPreview {
    @Override
    void sound() {
        System.out.println("야옹");
    }
}
