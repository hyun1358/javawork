package week06.day4;

public class Answer4 {
    public static void main(String[] args) {
        Beverage b = new Tea();
        b.brew();
        b.serve();
    }
}

abstract class Beverage {
    abstract void brew();

    void serve() {
        System.out.println("제공");
    }
}

class Tea extends Beverage {
    @Override
    void brew() {
        System.out.println("차 우려내기");
    }
}
