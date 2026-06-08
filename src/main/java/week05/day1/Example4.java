package week05.day1;

/**
 * [학습 예제 4] Week 05 Day 1 — 클래스와 객체의 기초
 * 
 * [문제별 학습 목표]
 * - Lab4: Rectangle 클래스의 상태 기반 면적/둘레 계산 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        // 가로 10, 세로 20의 사각형 생성 및 수식 테스트
        Rectangle rect = new Rectangle(10, 20);
        System.out.println("가로 10, 세로 20 사각형 넓이: " + rect.getArea());
        System.out.println("가로 10, 세로 20 사각형 둘레: " + rect.getPerimeter());
    }

    // Problem 4 연계 Rectangle 클래스 정의
    static class Rectangle {
        int width;
        int height;

        Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        int getArea() {
            return width * height;
        }

        int getPerimeter() {
            return 2 * (width + height);
        }
    }
}
