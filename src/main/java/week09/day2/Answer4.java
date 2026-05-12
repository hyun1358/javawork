package week09.day2;

import java.util.function.Supplier;

public class Answer4 {
    public static void main(String[] args) {
        Supplier<Integer> rand = () -> (int) (Math.random() * 10) + 1;
        System.out.println("난수: " + rand.get());
    }
}
