package week06.day3;

/**
 * [학습 예제 1] Week 06 Day 3 — 다형성(Polymorphism)의 심화
 * 
 * [학습 핵심 이론: 다형적 형변환과 런타임 바인딩]
 * 1. 업캐스팅 (Upcasting)과 다형성 배열:
 *    - 자식 객체의 주소값을 부모 타입 참조 변수에 담는 행위입니다.
 *    - 공통 조상 타입의 배열(`Shape[]`)을 선언하면 각기 다른 자식 인스턴스들을 일관되게 묶어 일괄 루프로 처리할 수 있어 확장성이 극대화됩니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: Shape 다형성 배열과 일괄 면적 출력 (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(5, 10),
            new Circle(7),
            new Rectangle(3, 5)
        };
        for (Shape s : shapes) {
            s.extent(); // 다형적 메서드 호출
        }
    }

    // Problem 1: Shape 계층 정의
    static class Shape {
        void extent() {
            System.out.println("도형의 넓이를 계산합니다.");
        }
    }

    static class Circle extends Shape {
        int radius;
        Circle(int radius) { this.radius = radius; }

        @Override
        void extent() {
            System.out.println("원 넓이: " + (radius * radius * 3.14));
        }
    }

    static class Rectangle extends Shape {
        int width, height;
        Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        void extent() {
            System.out.println("사각형 넓이: " + (width * height));
        }
    }
}
