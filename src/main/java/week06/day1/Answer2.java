package week06.day1;

public class Answer2 {
    public static void main(String[] args) {
        // Circle 객체를 생성합니다.
        Circle c = new Circle();
        
        // 부모 클래스(Shape)로부터 상속받은 color 필드를 사용합니다.
        c.color = "Red";
        // 자식 클래스(Circle)에 직접 정의된 radius 필드를 사용합니다.
        c.radius = 5;
        
        // 상속된 속성과 고유 속성을 모두 활용하여 출력합니다.
        System.out.println(c.color + "색 원, 반지름 " + c.radius);
    }
}

// [클래스 설명] 도형들의 공통 속성(색상)을 정의하는 부모 클래스입니다.
class Shape {
    String color;
}

// [클래스 설명] Shape를 상속받아 색상 속성을 기본으로 갖고, 원만의 특성인 반지름(radius)을 추가합니다.
class Circle extends Shape {
    int radius;
}

// [클래스 설명] Shape를 상속받아 색상 속성을 갖고, 직사각형만의 특성인 가로/세로(width/height)를 추가합니다.
class Rectangle extends Shape {
    int width, height;
}
