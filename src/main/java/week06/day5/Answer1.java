package week06.day5;

public class Answer1 {
    public static void main(String[] args) {
        FlyableAns b = new BirdAns();
        b.fly();
        FlyableAns a = new Airplane();
        a.fly();
    }
}

interface FlyableAns {
    void fly();
}

class BirdAns implements FlyableAns {
    public void fly() {
        System.out.println("새 날다");
    }
}

class Airplane implements FlyableAns {
    public void fly() {
        System.out.println("비행기 날다");
    }
}
