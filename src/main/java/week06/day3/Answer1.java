package week06.day3;

public class Answer1 {
    public static void main(String[] args) {
        Shape[] arr = {new Circle(5), new Rectangle(10, 20)};
        for (Shape s : arr) System.out.println("넓이: " + s.area());
    }
}

class Shape {
    double area() {
        return 0;
    }
}

class Circle extends Shape {
    int r;

    Circle(int r) {
        this.r = r;
    }

    @Override
    double area() {
        return Math.PI * r * r;
    }
}

class Rectangle extends Shape {
    int w, h;

    Rectangle(int w, int h) {
        this.w = w;
        this.h = h;
    }

    @Override
    double area() {
        return w * h;
    }
}
