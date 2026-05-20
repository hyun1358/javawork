package week08.day3;

import java.security.cert.CertPath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * [연습 문제 1] 숫자 리스트 정렬
 * 문제: 임의의 숫자들이 든 ArrayList를 오름차순과 내림차순으로 각각 정렬해 출력하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        List<Integer> number = new ArrayList<>(Arrays.asList(10,20,30,40,50,45,06,324));

        Collections.sort(number);
        System.out.println("오름차순"+number);

        Collections.sort(number , Collections.reverseOrder());
        System.out.println("내림차순"+number);


    }
}
