package week09.day2;

import java.util.function.Function;

public class Answer2 {
    public static void main(String[] args) {
        Function<String, String> toUpper = str -> str.toUpperCase();
        System.out.println(toUpper.apply("java"));
    }
}
