package week08.day4;

import java.util.*;

/**
 * HashSet을 사용하여 중복되지 않는 로또 번호 6개를 무작위로 추출하는 예제입니다.
 */
public class Answer4 {
    public static void main(String[] args) {
        Set<Integer> lotto = new HashSet<>();
        // Set의 크기가 6이 될 때까지 반복합니다. (중복된 난수는 무시됨)
        while (lotto.size() < 6) {
            lotto.add((int) (Math.random() * 45) + 1);
        }
        System.out.println("로또: " + lotto);
    }
}
