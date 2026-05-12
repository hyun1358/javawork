package week04.day1;

/**
 * [예습 파일] Week 04 Day 1 — 메서드 기초
 * <p>
 * ▶ 메서드(Method)란?
 * 자주 사용하는 코드를 하나로 묶어 이름을 붙인 '기능'입니다.
 * 코드의 재사용성과 가독성을 높여줍니다.
 */
public class Preview {
    public static void main(String[] args) {
        // 1. 메서드 호출 (매개변수 없음)
        sayHello();

        // 2. 매개변수가 있는 메서드 호출
        greet("Gemini");

        // 3. 반환값이 있는 메서드 호출
        int result = add(10, 20);
        System.out.println("10 + 20 = " + result);
    }

    // 인삿말을 출력하는 단순 메서드
    public static void sayHello() {
        System.out.println("안녕하세요! 메서드 학습을 시작합니다.");
    }

    // 이름을 받아 인사를 출력하는 메서드
    public static void greet(String name) {
        System.out.println(name + "님, 환영합니다!");
    }

    // 두 정수를 더해 결과를 돌려주는 메서드
    public static int add(int a, int b) {
        return a + b;
    }
}
