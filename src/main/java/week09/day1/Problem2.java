package week09.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * [연습 문제 2] 문자열 정렬 (길이 기준)
 * 문제: 문자열 리스트를 길이(length) 순으로 정렬하는 코드를 람다식을 사용하여 작성하세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>(Arrays.asList("asd","asdasd","asgdff","adtsafertg"));

        list.sort((s1,s2) -> s1.length() - s2.length());

        for(String s : list)
        {
            System.out.println(s);
        }
    }

}


