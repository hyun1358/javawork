package week06.day3;

public class Answer1 {
    public static void main(String[] args) {
        // 부모 타입(Shape)의 배열을 생성하여 다양한 자식 객체(Circle, Rectangle)를 한 번에 저장합니다. (다형성 활용)
        Shape[] arr = {new Circle(5), new Rectangle(10, 20)};
        
        // 향상된 for문을 사용하여 배열을 순회합니다.
        // 각 객체는 자신의 타입에 맞게 오버라이딩된 area() 메서드를 동적으로 호출합니다.
        for (Shape s : arr) System.out.println("넓이: " + s.area());
    }
}

// [클래스 설명] 다형성을 위한 부모 클래스로, 면적을 계산하는 기본 메서드를 제공합니다.
class Shape {
    // [메서드 설명] 기본 면적은 0으로 반환하며, 자식 클래스에서 재정의할 목적으로 만들어졌습니다.
    double area() {
        return 0;
    }
}

// [클래스 설명] Shape를 상속받은 원 클래스입니다.
class Circle extends Shape {
    int r; // 반지름

    Circle(int r) {
        this.r = r;
    }

    // [메서드 설명] 원의 넓이(π * r^2)를 계산하도록 면적 메서드를 오버라이딩합니다.
    @Override
    double area() {
        return Math.PI * r * r;
    }
}

// [클래스 설명] Shape를 상속받은 직사각형 클래스입니다.
class Rectangle extends Shape {
    int w, h; // 가로, 세로

    Rectangle(int w, int h) {
        this.w = w;
        this.h = h;
    }

    // [메서드 설명] 직사각형의 넓이(가로 * 세로)를 계산하도록 면적 메서드를 오버라이딩합니다.
    @Override
    double area() {
        return w * h;
    }
}
