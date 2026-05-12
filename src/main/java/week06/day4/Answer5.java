package week06.day4;

public class Answer5 {
    public static void main(String[] args) {
        Cooking c = new Pasta();
        c.cookRoutine();
    }
}

abstract class Cooking {
    final void cookRoutine() {
        wash();
        prep();
        cook();
        serve();
    }

    void wash() {
        System.out.println("재료 세척");
    }

    void prep() {
        System.out.println("재료 손질");
    }

    abstract void cook(); // 자식마다 다름

    void serve() {
        System.out.println("그릇에 담기");
    }
}

class Pasta extends Cooking {
    @Override
    void cook() {
        System.out.println("파스타 끓이기");
    }
}
