package week08.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [연습 문제 4] 와일드카드 <?>
 * 문제: 어떤 타입의 List든 받아서 출력할 수 있는 printList(List<?> list) 메서드를 구현하세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        List<String> strList = new ArrayList<>(Arrays.asList("안녕하세요","딸기","사과"));
        List<Integer> intList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,89,10));

        printList(strList);
        printList(intList);
    }

    static void printList(List<?> list)
    {
        List<?> obj = new ArrayList<>(list);

        for(Object item : obj)
        {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
