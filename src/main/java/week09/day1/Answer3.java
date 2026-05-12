package week09.day1;

public class Answer3 {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Hello Lambda!");
        r.run();
    }
}
