package week06.day4;

/**
 * [학습 예제 1] Week 06 Day 4 — 추상 클래스(Abstract Class)와 템플릿 메서드 패턴
 * 
 * [학습 핵심 이론: 추상 클래스를 통한 표준 설계 규격]
 * 2. 추상 메서드 (Abstract Method, `abstract returnType method()`):
 *    - 선언부만 있고 바디(`{ }`)가 없는 메서드로, 자식 클래스에게 해당 메서드를 반드시 재정의(Overriding)해서 완성하도록 강제성을 부여하는 표준 규격서 역할을 합니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: 추상 클래스 Shape 설계 및 Circle / Rectangle 구현 (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        Shape c = new Circle(3);
        Shape r = new Rectangle(3, 5);
        System.out.printf("원 넓이(반지름 3): %.2f\n", c.area());
        System.out.printf("사각형 넓이(3x5): %.2f\n", r.area());
    }

    // Problem 1: Shape 추상화
    static abstract class Shape {
        abstract double area(); // 자식들에게 무조건 구체적 면적 계산 수식을 구현하게 강제함
    }

    static class Circle extends Shape {
        int radius;
        Circle(int radius) { this.radius = radius; }

        @Override
        double area() {
            return radius * radius * Math.PI;
        }
    }

    static class Rectangle extends Shape {
        int width, height;
        Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        double area() {
            return width * height;
        }
    }
}
