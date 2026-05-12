package week06.day5;

public class Answer4 {
    public static void main(String[] args) {
        Machine m = new PC();
        m.on();
        m.off(); // default
    }
}

interface Machine {
    void on();

    default void off() {
        System.out.println("전원 끄기 기본 동작");
    }
}

class PC implements Machine {
    public void on() {
        System.out.println("PC 켜기");
    }
}
