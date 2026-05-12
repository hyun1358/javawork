package week05.day1;

/*
 * [정답 + 해설 4] Week 05 Day 1
 * 문제: 사각형 넓이와 둘레 계산
 */
public class Answer4 {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        rect.width = 10;
        rect.height = 20;

        System.out.println("가로: " + rect.width + ", 세로: " + rect.height);
        System.out.println("넓이: " + rect.getArea());
        System.out.println("둘레: " + rect.getPerimeter());
    }
}

class Rectangle {
    int width;
    int height;

    int getArea() {
        return width * height;
    }

    int getPerimeter() {
        return 2 * (width + height);
    }
}
