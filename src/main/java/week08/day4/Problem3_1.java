package week08.day4;

import java.util.*;

/**
 * [연습 문제 3-1] Map 구현체 3형제 비교 (HashMap vs TreeMap vs LinkedHashMap)
 * 문제: 동일한 데이터 (30, "C"), (10, "A"), (20, "B")를 각각
 *      HashMap, TreeMap, LinkedHashMap에 넣고 출력하여,
 *      각각 어떤 순서로 출력되는지 눈으로 확인하고 그 차이를 주석으로 적어 보세요.
 */
public class Problem3_1 {
    public static void main(String[] args)
    {
        // TODO
        Map<Integer,String> hashmap = new HashMap<>();
        hashmap.put(30,"C");
        hashmap.put(10,"A");
        hashmap.put(20,"B");

        Map<Integer,String> treemap = new TreeMap<>();
        treemap.put(30,"C");
        treemap.put(10,"A");
        treemap.put(20,"B");

        Map<Integer,String> linkMap = new LinkedHashMap<>();
        linkMap.put(30,"C");
        linkMap.put(10,"A");
        linkMap.put(20,"B");

        System.out.println(hashmap);//데이터를 put할때 데이터를 넣은 순서대로 출력이 안됨
        System.out.println(treemap);//데이터를 다 넣고 키를 기준으로 오름차순으로 정렬을 한다
        System.out.println(linkMap);//데이터를 넣은 순서대로 출력이 된다.
    }
}
