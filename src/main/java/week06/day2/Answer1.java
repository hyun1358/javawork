package week06.day2;

public class Answer1 {
    public static void main(String[] args) {
        DogAns d = new DogAns();
        d.sound();
        CatAns c = new CatAns();
        c.sound();
    }
}

class AnimalAns {
    void sound() {
        System.out.println("동물 소리");
    }
}

class DogAns extends AnimalAns {
    @Override
    void sound() {
        System.out.println("멍멍");
    }
}

class CatAns extends AnimalAns {
    @Override
    void sound() {
        System.out.println("야옹");
    }
}
