package week09.day2;

import java.util.function.BiFunction;

public class Answer5 {
    public static void main(String[] args) {
        BiFunction<Double, Double, Double> adder = (a, b) -> a + b;
        System.out.println("합: " + adder.apply(3.5, 2.1));
    }
}
