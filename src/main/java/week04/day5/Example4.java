package week04.day5;

/**
 * [학습 예제 4] Week 04 Day 5 — 메서드 설계와 문서화
 * 
 * [학습 핵심 이론: 클린 코드와 메서드 문서화 표준]
 * 4. Javadoc 문서화 표준 태그:
 *    - `@param`: 매개변수의 역할과 자료형 설명
 *    - `@return`: 반환되는 값의 의미와 범위 설명
 * 
 * [문제별 학습 목표]
 * - Lab4: Javadoc 표준 문서화 주석 적용 원의 넓이 계산 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        double circleArea = getCircleArea(5.0);
        System.out.printf("반지름 5.0 원의 넓이: %.2f\n", circleArea);
    }

    /**
     * 지정한 반지름 값을 기준으로 원의 넓이를 계산하여 반환합니다.
     *
     * @param radius 원의 반지름 값 (0보다 커야 함)
     * @return 원의 계산된 넓이 값 (PI * radius * radius)
     */
    public static double getCircleArea(double radius) {
        if (radius <= 0) {
            return 0.0;
        }
        return Math.PI * radius * radius;
    }
}
