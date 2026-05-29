package week08.day5;

import java.util.*;

/**
 * 와일드카드(?)를 사용하여 어떠한 제네릭 타입의 리스트라도 매개변수로 받을 수 있게 하는 예제입니다.
 */
public class Answer4 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<String> list2 = Arrays.asList("A", "B");
        printList(list1);
        printList(list2);
    }

    // 와일드카드 <?>를 사용하면 List<Integer>, List<String> 등 어떤 타입의 List도 인자로 받을 수 있습니다.
    public static void printList(List<?> list) {
        System.out.println(list);
    }
}
