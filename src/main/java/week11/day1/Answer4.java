package week11.day1;

public class Answer4 {
    public static void main(String[] args) {
        Shape s = ShapeFactory.create("circle");
        s.draw();
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("원 그리기");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("사각형 그리기");
    }
}

class ShapeFactory {
    public static Shape create(String type) {
        if ("circle".equals(type)) return new Circle();
        if ("rectangle".equals(type)) return new Rectangle();
        return null;
    }
}
