package week06.day4;

/**
 * [연습 문제 1] 추상 클래스 Shape
 * 문제: abstract Shape (area() 포함)를 만들고 Circle, Rectangle을 구현하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        Circle c = new Circle(3);
        System.out.println("Circle : " + c.area());
        Rectangle r = new Rectangle(3,5);
        System.out.println("Ractangle : " + r.area());
    }

    static abstract class Shape
    {
        abstract  double area();
    }

    static class Circle extends Shape
    {
        int radius;

        Circle(int radius) { this.radius = radius;}
        @Override
        double area()
        {
            return radius * radius * Math.PI;
        }
    }

    static class Rectangle extends Shape
    {
        int width,height;

        Rectangle(int width, int height)
        {
            this.width = width;
            this.height = height;
        }
        @Override
        double area()
        {
            return width * height;
        }
    }
}
