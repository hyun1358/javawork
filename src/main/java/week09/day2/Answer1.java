package week09.day2;

import java.util.function.Predicate;

public class Answer1 {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = n -> n > 0;
        System.out.println("양수 검사: " + isPositive.test(10));
        System.out.println("양수 검사: " + isPositive.test(-5));
    }
}
