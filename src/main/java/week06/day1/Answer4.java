package week06.day1;

public class Answer4 {
    public static void main(String[] args) {
        Car c = new Car("Hyundai", 200);
        c.show();
    }
}

class Vehicle {
    String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }
}

class Car extends Vehicle {
    int speed;

    Car(String brand, int speed) {
        super(brand);
        this.speed = speed;
    }

    void show() {
        System.out.println(brand + " " + speed);
    }
}
