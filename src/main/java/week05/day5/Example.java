package week05.day5;

/**
 * [학습 예제] Week 05 Day 5 — final의 쓰임새
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: 지역 final vs 멤버 final ===");
        final int local = 10;
        // local = 20; // 컴파일 에러

        System.out.println("\n=== Lab2: 잘 설계된 클래스의 특징 ===");
        System.out.println("1. 필드는 private으로 보호");
        System.out.println("2. 필요한 상수는 static final로 관리");
        System.out.println("3. 생성자를 통한 확실한 초기화");
    }
}
