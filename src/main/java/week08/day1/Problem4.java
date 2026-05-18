package week08.day1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * [연습 문제 4] 조건 필터링
 * 문제: 1~10까지 들어있는 리스트에서 짝수만 남기고 홀수는 삭제하세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO (힌트: removeIf 또는 역순 삭제)
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        numbers.removeIf(n -> n % 2 !=0);
        System.out.println(numbers);

        ArrayList<Integer> numbers2 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        for(int i = 0; i < numbers2.size(); i++)
        {
            if(numbers2.get(i) % 2 !=0)
            {
                numbers2.remove(i);
            }
        }

        System.out.println(numbers2);
    }
}
