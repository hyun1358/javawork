package week04.day3;

/**
 * [예습 파일] Week 04 Day 3 — 메서드 오버로딩 (Overloading)
 * 
 * [핵심 개념: 이름은 하나, 매개변수는 여러 개]
 * 1. 오버로딩(Overloading) 정의:
 *    - 한 클래스 내에서 같은 이름을 가진 메서드를 매개변수의 사양에 맞춰 여러 개 정의하는 고급 문법입니다.
 * 
 * 2. 오버로딩 성립 조건:
 *    - 메서드 이름이 완전히 동일해야 합니다.
 *    - 매개변수의 개수, 타입, 또는 순서 중 최소 하나가 달라야 구분이 가능합니다.
 *    - 반환 타입(Return Type)이나 접근 제어자는 오버로딩을 구분하는 기준이 될 수 없습니다! (컴파일 에러 유발)
 * 
 * 3. 대표적인 예시:
 *    - `System.out.println()`은 자바 API 내부에 문자열용, 정수형용, 실수형용 등으로 엄청나게 오버로딩되어 있어 개발자가 형변환 없이 호출할 수 있는 것입니다.
 */
public class Preview {
    public static void main(String[] args) {
        // 이름은 같지만 매개변수가 다른 메서드들을 호출합니다.
        System.out.println("정수 합: " + add(10, 20));
        System.out.println("실수 합: " + add(3.14, 2.5));
        System.out.println("세 수 합: " + add(1, 2, 3));
    }

    // 1. 기본 버전
    public static int add(int a, int b) {
        return a + b;
    }

    // 2. 타입이 다른 버전
    public static double add(double a, double b) {
        return a + b;
    }

    // 3. 개수가 다른 버전
    public static int add(int a, int b, int c) {
        return a + b + c;
    }
}
