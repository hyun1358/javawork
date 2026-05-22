package week08.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [학습 예제] Week 08 Day 5 — 제네릭 메서드와 와일드카드
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: 제네릭 메서드 ===");
        Integer[] arr = {1, 2, 3};
        printArray(arr); // 제네릭 메서드 호출
        System.out.println("\n[해설] 제네릭 메서드는 메서드 반환 타입 앞에 <T>와 같이 타입 매개변수를 정의하여, 다양한 데이터 타입의 배열 등을 단 하나의 메서드로 유연하게 처리할 수 있도록 도와줍니다.\n");

        System.out.println("=== Lab2: 타입 제한 (extends) ===");
        NumberBox<Double> nb = new NumberBox<>(3.14);
        System.out.println(nb.get());
        System.out.println("\n[해설] <T extends Number>와 같이 extends 키워드를 사용하여 제네릭 매개변수를 특정 클래스나 인터페이스의 하위 클래스로 제한(Bounded Type)함으로써 숫자형 객체만 다루도록 안전한 제약을 걸 수 있습니다.\n");

        System.out.println("=== Lab3: Arrays 유틸리티 및 ArrayList 제네릭 활용 ===");
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Generics");
        System.out.println("ArrayList 내용: " + list);

        Integer[] numArr = {10, 20, 30};
        System.out.println("Arrays.toString을 이용한 배열 출력: " + Arrays.toString(numArr));
        System.out.println("\n[해설] ArrayList와 같은 컬렉션에서도 제네릭을 명시하여 원하는 타입만 안전하게 담을 수 있으며, Arrays.toString() 유틸리티 메서드를 활용하면 배열 객체의 내용을 루프 없이 쉽게 대괄호 형태로 포맷하여 출력할 수 있습니다.\n");
    }

    /**
     * [제네릭 메서드 핵심 설명]
     * - 선언부: 'public static <T> void printArray(T[] array)'
     * 
     * 1. '<T>' (타입 매개변수 선언): 
     *    반환 타입(void) 바로 앞에 <T>를 붙여 이 메서드가 제네릭 메서드임을 컴파일러에 알립니다.
     *    여기서 정의된 'T'는 메서드 내에서 가상의 데이터 타입으로 자유롭게 활용됩니다.
     * 
     * 2. 'T[] array' (매개변수):
     *    가상의 타입 T로 선언된 배열을 입력 매개변수로 받습니다.
     *    덕분에 Integer[], String[], Double[] 등 모든 참조 타입 배열을 인자로 받아 유연하게 처리할 수 있습니다.
     * 
     * 3. 'for (T el : array)' (동작):
     *    전달받은 가상 타입 T의 배열 내부 요소를 '향상된 for문'으로 하나씩 꺼내(T el) 콘솔에 순서대로 출력합니다.
     */
    public static <T> void printArray(T[] array) {
        for (T el : array) System.out.print(el + " ");
        System.out.println();
    }
}

// 숫자 타입(Number)만 담을 수 있는 박스
class NumberBox<T extends Number> {
    private T num;

    NumberBox(T n) {
        this.num = n;
    }

    public T get() {
        return num;
    }
}
