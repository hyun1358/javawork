package week06.day1;

/**
 * [학습 예제 4] Week 06 Day 1 — 객체지향 상속(Inheritance)과 super
 * 
 * [학습 핵심 이론: 객체지향의 상속 매커니즘]
 * 2. super 키워드와 부모 생성자 위임:
 *    - 자식 생성자의 첫 줄에는 반드시 `super(...)`를 기입하여 부모 생성자를 위임 호출해야 합니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: super()를 이용한 부모 매개변수 생성자 위임 호출 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        Car myCar = new Car("현대", 180);
        myCar.showInfo();
    }

    // Problem 4: super() 활용 Vehicle & Car
    static class Vehicle {
        String brand;

        Vehicle(String brand) {
            this.brand = brand;
        }
    }

    static class Car extends Vehicle {
        int speed;

        Car(String brand, int speed) {
            super(brand); // 필수: 부모 생성자 호출 (전달인자 매핑)
            this.speed = speed;
        }

        void showInfo() {
            System.out.println("브랜드: " + brand + " | 속도: " + speed + "km/h");
        }
    }
}
