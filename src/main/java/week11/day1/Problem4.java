package week11.day1;

/**
 * [연습 문제 4] 도형 팩토리
 * 문제: "circle", "rectangle"을 받아 알맞은 Shape 객체를 반환하는 ShapeFactory를 구현하세요.
 * (단, Shape 인터페이스와 이를 구현하는 Circle, Rectangle 클래스를 직접 작성하세요.)
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        Shape s1 = ShapeFactory.create("circle");
        Shape s2 = ShapeFactory.create("rectangle");

        s1.draw();
        s2.draw();
    }

    static class Shape
    {
        void draw() {};
    }

    static class Circe extends Shape
    {
        void draw()
        {
            System.out.println("Circle 입니다.");
        }
    }

    static class Rectangle extends Shape
    {
        void draw()
        {
            System.out.println("Rectangle 입니다.");
        }
    }

    static class ShapeFactory
    {
        public static Shape create(String type)
        {
            if("Circle".equalsIgnoreCase(type))
            {
                return new Circe();
            }
            if("Rectangle".equalsIgnoreCase(type))
            {
                return new Rectangle();
            }
            throw new IllegalArgumentException("알 수 없는 도형: " + type);
        }
    }
}
