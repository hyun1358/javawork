package week04.day2;

/**
 * [학습 예제 5] Week 04 Day 2 — 메서드 매개변수 심화
 * 
 * [학습 핵심 이론: Call by Value 매커니즘 및 다형적 호출]
 * 1. 자바의 값 전달 원칙:
 *    - 자바는 무조건 'Call by Value(값에 의한 호출)' 방식으로만 매개변수를 전달합니다.
 */
public class Example5 {
    public static void main(String[] args) {
        int n = 100;
        update(n);
        System.out.println("update 호출 후 main의 n: " + n); // 100 출력 (기본형 복사)
    }

    static void update(int n) {
        n = 200;
    }
}
