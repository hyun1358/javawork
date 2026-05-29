package week11.day2;

import java.util.*;

// 전략(Strategy) 패턴의 일종으로, Comparator를 주입받아 정렬 방식을 결정하는 예제입니다.
public class Answer1 {
    // 메인 메서드
    public static void main(String[] args) {
        // 정렬할 리스트를 생성합니다.
        List<Integer> list = Arrays.asList(3, 1, 2);
        // Sorter 객체 생성 시, 내림차순 정렬을 위한 람다식(전략)을 주입합니다.
        Sorter s = new Sorter((o1, o2) -> o2 - o1); // 내림차순 람다
        // 주입받은 전략을 사용하여 리스트를 정렬합니다.
        s.sort(list);
        // 정렬된 결과를 출력합니다.
        System.out.println(list);
    }

    // 정렬 기능을 수행하는 클래스 (Context 역할)
    static class Sorter {
        Comparator<Integer> comp; // 외부에서 주입받을 정렬 전략

        // 생성자를 통해 구체적인 정렬 전략(Comparator)을 주입받습니다.
        Sorter(Comparator<Integer> c) {
            comp = c;
        }

        // 주입된 전략을 사용하여 실제 정렬을 수행하는 메서드
        void sort(List<Integer> list) {
            list.sort(comp);
        }
    }
}
