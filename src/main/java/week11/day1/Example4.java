package week11.day1;

/**
 * [학습 예제 4] Week 11 Day 1 — 싱글톤 패턴 & 팩토리 패턴 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 4] 팩토리 패턴 (Factory Pattern)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 객체 생성(new)을 팩토리 클래스/메서드에 위임
 *  - 클라이언트는 어떤 구체 클래스인지 몰라도 됨
 *  - 문자열 등 조건에 따라 다형적으로 객체를 반환
 *
 * [문제별 학습 목표]
 * - 문제 4: 팩토리 패턴 — ShapeFactory("circle"/"rectangle") → Shape 객체 반환
 */
public class Example4 {
    public static void main(String[] args) {
        // ─────────────────────────────────────────────
        // Lab 4: 팩토리 패턴 — ShapeFactory (→ 문제 4 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 4: ShapeFactory 패턴 ===");
        Shape circle = ShapeFactory.create("circle");
        Shape rect   = ShapeFactory.create("rectangle");
        circle.draw();   // 원 그리기
        rect.draw();     // 사각형 그리기
    }

    // ─── Lab 4: 팩토리 패턴 ───────────────────────────────
    interface Shape {
        void draw();
    }

    static class Circle implements Shape {
        public void draw() { System.out.println("원(Circle) 그리기"); }
    }

    static class Rectangle implements Shape {
        public void draw() { System.out.println("사각형(Rectangle) 그리기"); }
    }

    static class ShapeFactory {
        public static Shape create(String type) {
            if ("circle".equalsIgnoreCase(type))    return new Circle();
            if ("rectangle".equalsIgnoreCase(type)) return new Rectangle();
            throw new IllegalArgumentException("알 수 없는 도형: " + type);
        }
    }
}
