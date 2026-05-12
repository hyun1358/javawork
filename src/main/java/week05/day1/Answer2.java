package week05.day1;

/*
 * [정답 + 해설 2] Week 05 Day 1
 * 문제: Car 클래스 주행 정보 출력
 */
public class Answer2 {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.brand = "현대";
        myCar.speed = 100;
        myCar.color = "검정색";

        myCar.drive();
    }
}

class Car {
    String brand;
    int speed;
    String color;

    void drive() {
        System.out.println(brand + "의 " + color + " 차가 " + speed + "km/h로 달립니다.");
    }
}
