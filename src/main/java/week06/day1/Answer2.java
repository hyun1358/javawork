package week06.day1;

public class Answer2 {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.color = "Red";
        c.radius = 5;
        System.out.println(c.color + "색 원, 반지름 " + c.radius);
    }
}

class Shape {
    String color;
}

class Circle extends Shape {
    int radius;
}

class Rectangle extends Shape {
    int width, height;
}
