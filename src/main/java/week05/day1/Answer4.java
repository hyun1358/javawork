package week05.day1;

/*
 * [정답 + 해설 4] Week 05 Day 1
 * 문제: 사각형 넓이와 둘레 계산
 */
public class Answer4 {
    public static void main(String[] args) {
        // Rectangle 클래스의 인스턴스를 생성하여 rect 변수에 할당합니다.
        Rectangle rect = new Rectangle();
        
        // 직사각형의 가로와 세로 길이를 필드에 저장합니다.
        rect.width = 10;
        rect.height = 20;

        // 저장된 가로, 세로 길이를 출력합니다.
        System.out.println("가로: " + rect.width + ", 세로: " + rect.height);
        
        // 클래스 내부의 메서드를 호출하여 계산된 넓이와 둘레를 출력합니다.
        System.out.println("넓이: " + rect.getArea());
        System.out.println("둘레: " + rect.getPerimeter());
    }
}

// [클래스 설명] Rectangle 클래스는 직사각형의 상태(가로, 세로)를 저장하고 넓이와 둘레를 계산하는 기능을 제공합니다.
class Rectangle {
    int width;
    int height;

    // [메서드 설명] 객체가 가지고 있는 가로와 세로 값을 곱하여 직사각형의 넓이를 계산하고 반환합니다.
    int getArea() {
        return width * height;
    }

    // [메서드 설명] 객체가 가지고 있는 가로와 세로 값을 더한 후 2를 곱하여 직사각형의 둘레를 계산하고 반환합니다.
    int getPerimeter() {
        return 2 * (width + height);
    }
}
