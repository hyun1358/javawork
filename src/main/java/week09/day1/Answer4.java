package week09.day1;

import java.util.*;
import java.util.function.Consumer;

public class Answer4 {
    public static void main(String[] args) {
        Consumer<String> c1 = x -> System.out.println(x);
        Consumer<String> c2 = System.out::println; // 메서드 참조
        c2.accept("메서드 참조 테스트");
    }
}
