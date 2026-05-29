package week06.day4;

public class Answer5 {
    public static void main(String[] args) {
        // Cooking 타입으로 Pasta 요리 객체를 생성합니다.
        Cooking c = new Pasta();
        
        // 템플릿 메서드를 호출하면 일련의 요리 과정이 정해진 순서대로 실행됩니다.
        c.cookRoutine();
    }
}

// [클래스 설명] 템플릿 메서드 패턴(Template Method Pattern)을 구현한 추상 클래스입니다.
abstract class Cooking {
    // [메서드 설명] 요리의 전체 흐름(순서)을 정의한 템플릿 메서드입니다. 
    // final 키워드를 사용하여 자식 클래스에서 이 순서를 임의로 바꿀 수 없게 고정합니다.
    final void cookRoutine() {
        wash();
        prep();
        cook();  // 자식 클래스에서 구현된 메서드가 이 시점에 동적으로 호출됩니다.
        serve();
    }

    // 기본적으로 제공되는 공통 요리 단계들입니다.
    void wash() {
        System.out.println("재료 세척");
    }

    void prep() {
        System.out.println("재료 손질");
    }

    // [메서드 설명] 요리의 핵심 과정은 메뉴마다 다르므로 추상 메서드로 선언해 자식에게 맡깁니다.
    abstract void cook(); // 자식마다 다름

    void serve() {
        System.out.println("그릇에 담기");
    }
}

// [클래스 설명] Cooking 템플릿을 활용하여 파스타를 만드는 구체적인 자식 클래스입니다.
class Pasta extends Cooking {
    // [메서드 설명] 파스타 요리법에 맞게 cook 메서드만 오버라이딩합니다.
    @Override
    void cook() {
        System.out.println("파스타 끓이기");
    }
}
