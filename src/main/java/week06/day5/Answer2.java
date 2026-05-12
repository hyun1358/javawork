package week06.day5;

public class Answer2 {
    public static void main(String[] args) {
        DuckAns d = new DuckAns();
        d.fly();
        d.swim();
    }
}

interface Swimable {
    void swim();
}

interface Flyable2 {
    void fly();
}

class DuckAns implements Swimable, Flyable2 {
    public void fly() {
        System.out.println("날기");
    }

    public void swim() {
        System.out.println("수영");
    }
}
