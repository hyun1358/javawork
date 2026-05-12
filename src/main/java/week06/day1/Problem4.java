package week06.day1;

/**
 * [연습 문제 4] super()로 부모 생성자 호출
 * 문제: 부모 생성자에 매개변수가 있을 때, 자식 클래스에서 super()를 이용해 초기화하세요.
 */
public class Problem4 {
    public static void main(String[] args) {
        // TODO: 구현
        Car c = new Car("Hyundai", 200);
        c.show();
    }

    static class Vehicle {
        String brand;

        Vehicle(String brand) {
            this.brand = brand;
        }
    }

    static class Car extends Vehicle {
        int speed;

        Car(String brand, int speed) {
            super(brand);
            this.speed = speed;
        }

        void show() {
            System.out.println(brand + " " + speed);
        }
    }

}
