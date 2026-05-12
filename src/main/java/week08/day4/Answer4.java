package week08.day4;

import java.util.*;

public class Answer4 {
    public static void main(String[] args) {
        Set<Integer> lotto = new HashSet<>();
        while (lotto.size() < 6) {
            lotto.add((int) (Math.random() * 45) + 1);
        }
        System.out.println("로또: " + lotto);
    }
}
