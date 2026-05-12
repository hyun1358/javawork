package week09.day2;

import java.util.function.Consumer;

public class Answer3 {
    public static void main(String[] args) {
        Consumer<Integer> printer = n -> System.out.println("입력값: " + n);
        printer.accept(100);
    }
}
