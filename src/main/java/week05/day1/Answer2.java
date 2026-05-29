package week05.day1;

/*
 * [정답 + 해설 2] Week 05 Day 1
 * 문제: Car 클래스 주행 정보 출력
 */
public class Answer2 {
    public static void main(String[] args) {
        // Car 클래스 타입의 myCar 객체를 생성하여 인스턴스화합니다.
        Car myCar = new Car();
        
        // myCar 객체의 각 필드에 자동차의 상태값을 설정합니다.
        myCar.brand = "현대";
        myCar.speed = 100;
        myCar.color = "검정색";

        // 설정된 상태값을 바탕으로 주행 메서드를 실행합니다.
        myCar.drive();
    }
}

// [클래스 설명] Car 클래스는 자동차의 브랜드, 속도, 색상 속성과 주행 동작을 나타냅니다.
class Car {
    String brand;
    int speed;
    String color;

    // [메서드 설명] 자동차의 현재 상태(브랜드, 색상, 속도)를 문자열로 조합하여 출력합니다.
    void drive() {
        System.out.println(brand + "의 " + color + " 차가 " + speed + "km/h로 달립니다.");
    }
}
