package week06.day3;

/**
 * [예습 파일] Week 06 Day 3 — 다형성 (Polymorphism)
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
