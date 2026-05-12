package week06.day1;

/**
 * [연습 문제 2] Shape -> Circle, Rectangle
 * 문제: Shape(색상)를 상속받는 Circle(반지름)과 Rectangle(너비, 높이)을 구현하세요.
 */
public class Problem2 {
    public static void main(String[] args) {
        // TODO: 구현
        Circle c = new Circle(5);
        c.result();
        Rectangle r = new Rectangle(10, 5);
        r.result();
    }

    static class Shape {
        String color;
    }

    static class Circle extends Shape {
        int radius;

        Circle(int radius) {
            this.radius = radius;
            this.color = "빨강";
        }

        Circle(int radius, String color) {
            this.radius = radius;
            this.color = color;
        }

        void result() {
            System.out.println(radius * radius * 3.14);
        }
    }

    static class Rectangle extends Shape {
        int width, height;

        Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
            this.color = "빨강";
        }

        Rectangle(int width, int height, String color) {
            this.width = width;
            this.height = height;
            this.color = color;
        }

        void result() {
            System.out.println(width * height);
        }
    }
}
