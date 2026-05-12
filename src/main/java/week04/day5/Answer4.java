package week04.day5;

public class Answer4 {
    /**
     * 반지름을 입력받아 원의 넓이를 계산합니다.
     *
     * @param radius 원의 반지름 (0보다 커야 함)
     * @return 계산된 원의 넓이
     */
    public static double getArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        System.out.println(getArea(5.0));
    }
}
