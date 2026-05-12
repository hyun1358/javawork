package week05.day1;

/**
 * [연습 문제 4] Week 05 Day 1 - 정답 반영됨
 * <p>
 * 문제: 사각형의 넓이와 둘레를 계산하는 Rectangle 클래스를 만드세요.
 * 1. 필드: width(가로), height(세로)
 * 2. 메서드:
 * - getArea(): 가로 * 세로 결과 반환
 * - getPerimeter(): 2 * (가로 + 세로) 결과 반환
 * <p>
 * 난이도: ★★☆☆☆
 */
public class Problem4 {
    public static void main(String[] args) {
        // 사각형 객체 생성 및 문제 요구 데이터(10, 20) 입력
        Rectangle rectangle = new Rectangle(10, 20);

        System.out.println("사각형 넓이: " + rectangle.getArea());
        System.out.println("사각형 둘레: " + rectangle.getPerimeter());

    }

    static class Rectangle {
        int width, height;

        Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        int getArea() {
            return this.width * this.height;
        }

        int getPerimeter() {
            // 둘레 공식: 2 * (가로 + 세로)
            return 2 * (this.width + this.height);
        }
    }
}
