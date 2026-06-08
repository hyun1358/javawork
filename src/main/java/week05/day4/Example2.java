package week05.day4;

/**
 * [학습 예제 2] Week 05 Day 4 — static과 메모리 구조
 * 
 * [학습 핵심 이론: static 키워드와 클래스 멤버]
 * 2. static 메서드 (정적 메서드):
 *    - 객체 생성(new) 없이 클래스 이름으로 직접 호출 가능합니다.
 *    - 상태값을 유지하지 않는 순수 계산용 유틸리티에 적합합니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: static 메서드로 구성된 수학 유틸리티 클래스 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        int result = MyMath.abs(-7);
        System.out.println("MyMath.abs(-7) 결과: " + result);
    }

    // Problem 2: MyMath 클래스 정의 (정적 유틸리티)
    static class MyMath {
        // 객체 생성 없이 사용하는 static abs 메서드
        public static int abs(int n) {
            return n < 0 ? -n : n;
        }
    }
}
