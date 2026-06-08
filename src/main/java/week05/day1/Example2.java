package week05.day1;

/**
 * [학습 예제 2] Week 05 Day 1 — 클래스와 객체의 기초
 * 
 * [학습 핵심 이론: 객체지향 프로그래밍(OOP) 기초]
 * 2. 상태(Fields)와 행위(Methods):
 *    - 필드는 객체가 가지는 데이터 속성을 저장하는 멤버 변수입니다.
 *    - 메서드는 객체가 수행하는 행동이나 함수적 연산입니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: Car 클래스 설계와 포맷팅 출력 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        // Car 객체 생성 및 drive 실행
        Car myCar = new Car("현대", 120, "빨간색");
        myCar.drive();
    }

    // Problem 2 연계 Car 클래스 정의
    static class Car {
        String brand;
        int speed;
        String color;

        Car(String brand, int speed, String color) {
            this.brand = brand;
            this.speed = speed;
            this.color = color;
        }

        void drive() {
            System.out.printf("[%s]의 [%s] 차가 [%d]km/h로 달립니다.\n", brand, color, speed);
        }
    }
}
