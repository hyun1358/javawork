package week11.day1;

// Simple Factory (단순 팩토리) 패턴을 구현한 예제 클래스입니다.
public class Answer4 {
    // 메인 메서드
    public static void main(String[] args) {
        // 팩토리 클래스의 정적 메서드를 호출하여 "circle" 문자열에 해당하는 구체적인 객체를 생성받습니다.
        Shape s = ShapeFactory.create("circle");
        // 반환된 객체가 null이 아니면 다형성을 이용하여 draw() 메서드를 호출합니다.
        if (s != null) s.draw();
    }

    // 여러 도형 객체가 공통으로 구현해야 하는 인터페이스 (다형성의 기반)
    interface Shape {
        void draw(); // 도형을 그리는 기능을 정의
    }

    // Shape 인터페이스를 구현한 구체적인 원(Circle) 클래스
    static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("원 그리기");
        }
    }

    // Shape 인터페이스를 구현한 구체적인 사각형(Rectangle) 클래스
    static class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("사각형 그리기");
        }
    }

    // 객체 생성 로직을 캡슐화한 팩토리 클래스
    static class ShapeFactory {
        // 전달받은 문자열 타입에 따라 알맞은 Shape 구현체 객체를 생성하여 반환합니다.
        public static Shape create(String type) {
            if ("circle".equals(type)) return new Circle();
            if ("rectangle".equals(type)) return new Rectangle();
            return null; // 정의되지 않은 타입의 경우 null을 반환합니다.
        }
    }
}
