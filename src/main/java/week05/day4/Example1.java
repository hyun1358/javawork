package week05.day4;

/**
 * [학습 예제 1] Week 05 Day 4 — static과 메모리 구조
 * 
 * [학습 핵심 이론: static 키워드와 클래스 멤버]
 * 1. static 변수 (정적 변수 / 클래스 변수):
 *    - 클래스가 메모리(Method Area)에 로딩될 때 딱 한 번 할당되며, 해당 클래스로 생성된 모든 인스턴스가 공간을 공유합니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: static 필드를 이용한 객체 카운터 (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        Circle.count = 0; // 테스트 전 초기화
        new Circle();
        new Circle();
        new Circle();
        System.out.println("최종 생성된 원의 개수: " + Circle.count);
    }

    // Problem 1: Circle 클래스 정의 (static 카운터)
    static class Circle {
        static int count = 0; // 모든 Circle 객체가 공유하는 정적 변수

        Circle() {
            count++;
            System.out.println("[객체 생성] 새로운 원이 생성되었습니다. (현재 누적 개수: " + count + ")");
        }
    }
}
