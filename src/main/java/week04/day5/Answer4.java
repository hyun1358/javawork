package week04.day5;

public class Answer4 {
    /**
     * JavaDoc 주석: 반지름을 입력받아 원의 넓이를 계산합니다.
     * 이 주석은 코드를 설명하거나 문서화할 때 유용합니다.
     * 
     * @param radius 원의 반지름 (0보다 커야 함)
     * @return 계산된 원의 넓이
     */
    public static double getArea(double radius) {
        // Math.PI 상수를 이용하여 파이 값을 얻고, 반지름의 제곱을 곱해 반환
        return Math.PI * radius * radius;
    }

    // 메인 메서드: getArea 메서드를 호출하여 원의 넓이 계산 테스트
    public static void main(String[] args) {
        // 반지름 5.0인 원의 넓이를 계산하여 출력
        System.out.println(getArea(5.0));
    }
}
