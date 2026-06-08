package week08.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [학습 예제 4] Week 08 Day 5 — 제네릭(Generics) 심화와 와일드카드
 * 
 * [학습 핵심 이론: 컴파일 타임 타입 안전성 보장 - 제네릭]
 * 3. 와일드카드 (`<?>`, Unbounded Wildcard):
 *    - 제네릭 타입의 상속 관계 및 타입 매칭 유연성을 확보하기 위해 도입되었습니다.
 *    - `List<?>`는 어떤 타입의 리스트든 가리지 않고 인자로 받아 요소를 읽어들일 수 있는 범용 뷰어 역할을 훌륭히 해냅니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: 와일드카드 <?>를 이용한 임의 타입 리스트 일괄 출력 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab4: 와일드카드 <?>를 이용한 임의 타입 리스트 일괄 출력 (Problem 4 연계) ---");
        Lab4.run();
    }

    // Problem 4: 와일드카드 printList
    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    static class Lab4 {
        static void run() {
            List<String> strList = new ArrayList<>(Arrays.asList("안녕하세요", "딸기", "사과"));
            List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

            System.out.print("문자열 리스트 출력: ");
            printList(strList);

            System.out.print("정수 리스트 출력: ");
            printList(intList);
        }
    }
}
