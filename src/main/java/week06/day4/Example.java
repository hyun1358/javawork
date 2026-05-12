package week06.day4;

/**
 * [학습 예제] Week 06 Day 4 — 템플릿 메서드 패턴 맛보기
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: 템플릿 메서드 ===");
        CoffeeMaker cm = new AmericanoMaker();
        cm.makeCoffee(); // 부모의 뼈대(흐름)대로 진행, 세부구현은 자식의 것 호출
    }
}

abstract class CoffeeMaker {
    final void makeCoffee() { // 자식이 흐름을 못바꾸게 final
        boilWater();
        brew();
        pour();
    }

    void boilWater() {
        System.out.println("물 끓이기");
    }

    abstract void brew(); // 추출 방식은 자식이 구현

    void pour() {
        System.out.println("컵에 붓기");
    }
}

class AmericanoMaker extends CoffeeMaker {
    @Override
    void brew() {
        System.out.println("에스프레소 샷 추출");
    }
}
