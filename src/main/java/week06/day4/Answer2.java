package week06.day4;

public class Answer2 {
    public static void main(String[] args) {
        AnimalAns a = new DogAns();
        a.sound();
        a.breathe();
    }
}

abstract class AnimalAns {
    abstract void sound();

    void breathe() {
        System.out.println("호흡");
    }
}

class DogAns extends AnimalAns {
    @Override
    void sound() {
        System.out.println("멍멍");
    }
}
