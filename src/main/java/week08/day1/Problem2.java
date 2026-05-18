package week08.day1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * [연습 문제 2] 점수 리스트 통계
 * 문제: 점수를 저장하는 ArrayList(Integer)의 합계와 평균을 구하세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10,20,30,40,50));

        int sum = 0;
        double avg = 0;

        for(int i = 0; i < numbers.size(); i++)
        {
            sum+= numbers.get(i);
        }
        avg = (sum / numbers.size());
        System.out.printf("합계 : %d, 평균: %.1f",sum,avg);
    }
}
