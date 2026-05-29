package week04.day3;

public class Answer5 {
    // 메인 메서드: 메서드 오버로딩을 활용하여 다양한 도형의 넓이를 구하는 기능 테스트
    public static void main(String[] args) {
        // 인자가 double 1개인 경우 -> 원의 넓이 계산 메서드 호출
        System.out.println("원: " + area(5.0));
        // 인자가 int 2개인 경우 -> 직사각형의 넓이 계산 메서드 호출
        System.out.println("사각형: " + area(10, 20));
        // 인자가 double 2개인 경우 -> 삼각형의 넓이 계산 메서드 호출
        System.out.println("삼각형: " + area(10.0, 5.0));
    }

    // area 메서드 오버로딩 1: 원의 넓이를 계산 (반지름 * 반지름 * 파이)
    public static double area(double r) {
        return Math.PI * r * r;
    }

    // area 메서드 오버로딩 2: 직사각형의 넓이를 계산 (가로 * 세로)
    public static int area(int w, int h) {
        return w * h;
    }

    // area 메서드 오버로딩 3: 삼각형의 넓이를 계산 (밑변 * 높이 / 2)
    public static double area(double base, double height) {
        return base * height / 2;
    }
}
