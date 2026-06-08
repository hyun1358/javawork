package week11.day3;

/**
 * [학습 예제 3] Week 11 Day 3 — 빌더/데코레이터/커맨드 패턴 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 3] 데코레이터 패턴 (Decorator Pattern)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 기존 객체를 감싸서(wrap) 기능을 동적으로 추가
 *  - 기본 객체 + 데코레이터들을 겹겹이 포장
 *  - 상속 없이 기능 확장 → 개방-폐쇄 원칙(OCP) 준수
 *
 * [문제별 학습 목표]
 * - 문제 3: 데코레이터 패턴 — BasicPizza + 치즈/페퍼로니 데코레이터
 */
public class Example3 {
    public static void main(String[] args) {
        // ─────────────────────────────────────────────
        // Lab 3: 데코레이터 패턴 — 피자 (→ 문제 3 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 3: 데코레이터 패턴 — 피자 ===");
        Pizza pizza = new BasicPizza();
        System.out.println(pizza.getDescription() + " / 가격: " + pizza.getPrice() + "원");

        pizza = new CheeseDecorator(pizza); // 치즈 추가
        System.out.println(pizza.getDescription() + " / 가격: " + pizza.getPrice() + "원");

        pizza = new PepperoniDecorator(pizza); // 페퍼로니 추가
        System.out.println(pizza.getDescription() + " / 가격: " + pizza.getPrice() + "원");
    }

    // ─── 데코레이터 패턴: 피자 ────────────────────────────
    interface Pizza {
        String getDescription();
        int getPrice();
    }

    static class BasicPizza implements Pizza {
        public String getDescription() { return "기본 피자"; }
        public int getPrice() { return 8000; }
    }

    abstract static class PizzaDecorator implements Pizza {
        protected Pizza pizza;
        PizzaDecorator(Pizza p) { this.pizza = p; }
    }

    static class CheeseDecorator extends PizzaDecorator {
        CheeseDecorator(Pizza p) { super(p); }
        public String getDescription() { return pizza.getDescription() + " + 치즈"; }
        public int getPrice() { return pizza.getPrice() + 1500; }
    }

    static class PepperoniDecorator extends PizzaDecorator {
        PepperoniDecorator(Pizza p) { super(p); }
        public String getDescription() { return pizza.getDescription() + " + 페퍼로니"; }
        public int getPrice() { return pizza.getPrice() + 2000; }
    }
}
