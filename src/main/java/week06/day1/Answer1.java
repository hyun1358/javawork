package week06.day1;

public class Answer1 {
    public static void main(String[] args) {
        DogAns d = new DogAns();
        d.name = "멍멍이";
        d.bark();

        CatAns c = new CatAns();
        c.name = "야옹이";
        c.meow();
    }
}

class AnimalAns {
    String name;
}

class DogAns extends AnimalAns {
    void bark() {
        System.out.println(name + ": 멍멍");
    }
}

class CatAns extends AnimalAns {
    void meow() {
        System.out.println(name + ": 야옹");
    }
}
