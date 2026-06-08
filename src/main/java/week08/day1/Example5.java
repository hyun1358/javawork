package week08.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [학습 예제 5] Week 08 Day 1 — 자료구조 컬렉션 ArrayList 기초
 * 
 * [문제별 학습 목표]
 * - Lab5: 일반 배열과 ArrayList 간의 완벽한 양방향 변환 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab5: 일반 배열과 ArrayList 간의 완벽한 양방향 변환 (Problem 5 연계) ---");
        Lab5.run();
    }

    static class Lab5 {
        static void run() {
            // Problem 5: 배열 ↔ 리스트 양방향 변환
            String[] languages = {"Java", "Python", "C++"};
            System.out.println("1. 원시 배열: " + Arrays.toString(languages));

            // [방향 1] 배열 -> 리스트 변환 (Arrays.asList는 고정크기이므로 ArrayList로 감싸야 요소를 추가할 수 있습니다.)
            List<String> list = new ArrayList<>(Arrays.asList(languages));
            list.add("Kotlin");
            System.out.println("2. 변환된 리스트 (Kotlin 추가): " + list);

            // [방향 2] 리스트 -> 배열 변환 (toArray 활용)
            // new String[0]은 빈 배열을 전달하되, JVM이 리스트 크기에 맞춰 알아서 적절한 크기의 새 배열을 할당해 줍니다.
            String[] newArr = list.toArray(new String[0]);
            System.out.println("3. 최종 복원된 배열: " + Arrays.toString(newArr));
        }
    }
}
