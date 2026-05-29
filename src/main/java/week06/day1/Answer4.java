package week06.day1;

public class Answer4 {
    public static void main(String[] args) {
        // Car 객체를 생성하며 브랜드와 속도 값을 전달합니다.
        // 이때 Car의 생성자 내부에서 부모(Vehicle)의 생성자도 호출됩니다.
        Car c = new Car("Hyundai", 200);
        
        // 차량의 상태를 출력하는 메서드를 호출합니다.
        c.show();
    }
}

// [클래스 설명] 차량의 기본 브랜드 정보를 다루는 부모 클래스입니다.
class Vehicle {
    String brand;

    // [생성자 설명] 매개변수가 있는 부모 생성자입니다. 기본 생성자가 없으므로 자식 클래스에서 반드시 명시적으로 호출해야 합니다.
    Vehicle(String brand) {
        this.brand = brand;
    }
}

// [클래스 설명] Vehicle을 상속받아 자동차의 속도 속성을 추가한 자식 클래스입니다.
class Car extends Vehicle {
    int speed;

    // [생성자 설명] 자식 클래스의 생성자입니다.
    Car(String brand, int speed) {
        // 부모 생성자 호출(super)은 반드시 자식 생성자의 첫 줄에 위치해야 합니다.
        // 이를 통해 부모의 brand 필드를 먼저 안전하게 초기화합니다.
        super(brand);
        this.speed = speed; // 그 다음 자식의 고유 필드를 초기화합니다.
    }

    // [메서드 설명] 상속받은 브랜드와 자신의 속도를 조합해 출력합니다.
    void show() {
        System.out.println(brand + " " + speed);
    }
}
