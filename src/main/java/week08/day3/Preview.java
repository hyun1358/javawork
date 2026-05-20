package week08.day3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * [예습 파일] Week 08 Day 3 — 기본 정렬 (Collections.sort)
 * 
 * 정렬(Sorting)은 데이터를 특정 기준(오름차순, 내림차순 등)에 따라 재배치하는 과정입니다.
 * 자바의 Collections 클래스는 컬렉션 데이터를 다루는 유용한 도구들을 제공하며, 
 * 그 중 sort() 메서드는 리스트를 매우 간편하게 정렬해줍니다.
 * 
 * 1. Collections.sort(list):
 *    - 리스트에 들어있는 요소들을 '자연스러운 순서(Natural Order)'로 정렬합니다.
 *    - Integer나 String 같은 기본 클래스들은 이미 내부적으로 정렬 기준이 정의되어 있습니다.
 * 
 * 2. Collections.sort(list, Collections.reverseOrder()):
 *    - 기본 정렬 기준의 반대(내림차순)로 정렬할 때 사용합니다.
 */
public class Preview {
    public static void main(String[] args) {
        // 정수형 데이터를 담는 리스트 생성
        ArrayList<Integer> list = new ArrayList<>();
        list.add(50);
        list.add(10);
        list.add(30);

        // 1. 오름차순 정렬 (작은 것 -> 큰 것)
        // Collections.sort()는 원본 리스트를 직접 변경합니다.
        Collections.sort(list); 
        System.out.println("오름차순 정렬: " + list); // [10, 30, 50]

        // 2. 내림차순 정렬 (큰 것 -> 작은 것)
        // 두 번째 인자로 정렬 기준(Comparator)을 넘겨줄 수 있습니다.
        Collections.sort(list, Collections.reverseOrder()); 
        System.out.println("내림차순 정렬: " + list); // [50, 30, 10]
    }
}
