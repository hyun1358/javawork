package week06.day3;

/**
 * [연습 문제 1] 다형성 배열 구현
 * 문제: Shape[] 배열에 Circle, Rectangle 객체를 담아 넓이를 출력하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        Shape[] s = new Shape[4];
        s[0] = new Circle(5);
        s[1] = new Rectangle(5,10);
        s[2] = new Circle(7);
        s[3] = new Rectangle(3,5);

        for(Shape S : s)
            S.extent();
    }

    static class Shape
    {
        void extent() {}
    }

    static class Circle extends Shape
    {
        int radius;

        Circle(int radius)
        {
            this.radius = radius;
        }

        @Override
        void extent()
        {
            System.out.println( radius * radius * 3.14);
        }
    }

    static class Rectangle extends Shape
    {
        int width;
        int height;

        Rectangle(int width, int height) { this.width = width; this.height = height;}

        @Override
        void extent()
        {
            System.out.println( width * height);
        }
    }
}
