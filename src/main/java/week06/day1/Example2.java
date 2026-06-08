package week06.day1;

/**
 * [학습 예제 2] Week 06 Day 1 — 객체지향 상속(Inheritance)과 super
 * 
 * [문제별 학습 목표]
 * - Lab2: Shape 클래스 상속 및 자식별 개별 연산 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        Circle c = new Circle(5, "빨강");
        Rectangle r = new Rectangle(10, 5, "파랑");
        c.showArea();
        r.showArea();
    }

    // Problem 2: Shape 클래스 계층
    static class Shape {
        String color;
    }

    static class Circle extends Shape {
        int radius;

        Circle(int radius, String color) {
            this.radius = radius;
            this.color = color; // 상속받은 필드
        }

        void showArea() {
            double area = radius * radius * 3.14;
            System.out.printf("[%s 원] 반지름: %d | 면적: %.2f\n", color, radius, area);
        }
    }

    static class Rectangle extends Shape {
        int width, height;

        Rectangle(int width, int height, String color) {
            this.width = width;
            this.height = height;
            this.color = color;
        }

        void showArea() {
            int area = width * height;
            System.out.printf("[%s 사각형] 가로 %d x 세로 %d | 면적: %d\n", color, width, height, area);
        }
    }
}
