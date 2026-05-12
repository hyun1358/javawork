package week05.day1;

/**
 * [연습 문제 2] Week 05 Day 1
 * <p>
 * 문제: Car 클래스를 만들고 주행 정보를 출력하세요.
 * 1. 필드: brand(브랜드), speed(속도), color(색상)
 * 2. 메서드: drive() - "[브랜드]의 [색상] 차가 [속도]km/h로 달립니다." 출력
 * <p>
 * 난이도: ★☆☆☆☆
 */
public class Problem2 {
    public static void main(String[] args) {
        // TODO: Car 객체를 생성하고 값을 넣어 drive()를 실행하세요.
        Car car = new Car("현대", 40, "빨간색");
        car.drive();

    }

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
            System.out.printf("[%s]의 [%s] 차가 [%d]km/h로 달립니다.", brand, color, speed);
        }
    }
}
