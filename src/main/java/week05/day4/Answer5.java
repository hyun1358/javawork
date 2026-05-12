package week05.day4;

public class Answer5 {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2); // true
    }
}

class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    } // 밖에서 new 못하게 막음

    public static Singleton getInstance() {
        return instance;
    }
}
