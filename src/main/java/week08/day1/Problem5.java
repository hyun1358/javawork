package week08.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [연습 문제 5] 배열 ↔ 리스트 변환
 * 문제: 배열을 리스트로 변환하고, 다시 다른 배열로 변환해보세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        String[] languages = {"Java","Python","C++"};

        List<String> list = new ArrayList<>(Arrays.asList(languages));
        list.add("Kotlin");
        System.out.println(list);

        String[] newArr = list.toArray(new String[0]);
        System.out.println(Arrays.toString(newArr));
    }
}
