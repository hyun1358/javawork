package week09.day2;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * [학습 예제] Week 09 Day 2 — Consumer와 Supplier
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: Consumer (소비자) ===");
        Consumer<String> greeter = name -> System.out.println("Hello, " + name);
        greeter.accept("Alice");

        System.out.println("\n=== Lab2: Supplier (공급자) ===");
        Supplier<Double> randomNum = () -> Math.random();
        System.out.println("랜덤값: " + randomNum.get());
    }
}
