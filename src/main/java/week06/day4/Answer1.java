package week06.day4;

public class Answer1 {
    public static void main(String[] args) {
        Shape c = new Circle(5);
        System.out.println(c.area());
    }
}

abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    int r;

    Circle(int r) {
        this.r = r;
    }

    @Override
    double area() {
        return 3.14 * r * r;
    }
}
