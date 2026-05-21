package week08.day4;

import java.util.HashSet;

/**
 * [연습 문제 4] 로또 번호 (HashSet 사용)
 * 문제: 1~45 사이 난수를 HashSet에 저장하여 자동으로 중복 없이 6개가 모일 때까지 반복하세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO

        HashSet<Integer> lotto = new HashSet<>();
        while(lotto.size() < 6)
        {
            int random = (int)(Math.random()*45)+1;
            lotto.add(random);
        }

        System.out.println(lotto);
    }
}
