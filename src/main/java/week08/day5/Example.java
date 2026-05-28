package week08.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [학습 예제] Week 08 Day 5 — 제네릭(Generics) 심화와 와일드카드 (Box 제네릭 클래스, swap 제네릭 메서드, Stack 제네릭 자료구조, printList 와일드카드, 타입 매개변수 네이밍 관례)
 * 
 * [학습 핵심 이론: 컴파일 타임 타입 안전성 보장 - 제네릭]
 * 1. 제네릭 클래스 (Generic Class):
 *    - 클래스 정의 시 특정 데이터 타입을 지정하지 않고, 가상의 타입 매개변수 `<T>`를 사용해 컴파일 타임에 타입 결정을 위임하는 클래스입니다. (Problem 1 연계)
 * 
 * 2. 제네릭 메서드 (Generic Method):
 *    - 반환 타입 앞에 `<T>`를 선언하여 메서드 호출 시점에 유동적으로 매개변수나 반환 형식을 결정하는 메서드입니다. (Problem 2 연계)
 * 
 * 3. 와일드카드 (`<?>`, Unbounded Wildcard):
 *    - 제네릭 타입의 상속 관계 및 타입 매칭 유연성을 확보하기 위해 도입되었습니다.
 *    - `List<?>`는 어떤 타입의 리스트든 가리지 않고 인자로 받아 요소를 읽어들일 수 있는 범용 뷰어 역할을 훌륭히 해냅니다. (Problem 4 연계)
 * 
 * 4. 타입 파라미터 네이밍 관례:
 *    - `T`: Type (가장 일반적인 자료형 지칭)
 *    - `E`: Element (ArrayList 등 컬렉션 요소 지칭)
 *    - `K`: Key (Map의 Key 지칭)
 *    - `V`: Value (Map의 Value 지칭)
 *    - `N`: Number (숫자 전용 지칭) (Problem 5 연계)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 08 Day 5 학습 예제 ===\n");

        System.out.println("--- Lab1: generic 클래스 Box<T> 활용 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: generic 메서드 <T> swap 구현 및 두 요소 교환 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: ArrayList를 캡슐화한 generic Stack<T> 구현 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: 와일드카드 <?>를 이용한 임의 타입 리스트 일괄 출력 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: 제네릭 타입 파라미터 표준 네이밍 관례 설명 (Problem 5 연계) ---");
        Lab5.run();

        System.out.println("\n--- Lab6: Bounded Type Parameter <T extends Number> (보너스) ---");
        Lab6.run();
    }

    // Problem 1: 제네릭 클래스 Box<T> 정의
    static class Box<T> {
        private T content;

        Box(T content) {
            this.content = content;
        }

        public T getBox() { return content; }
        public void setBox(T content) { this.content = content; }
    }

    // Problem 3: 제네릭 스택 Stack<T> 정의
    static class Stack<T> {
        private final List<T> list = new ArrayList<>();

        public void push(T item) {
            list.add(item);
        }

        public T pop() {
            if (list.isEmpty()) {
                throw new IllegalStateException("스택이 비어 있어 꺼낼 수 없습니다.");
            }
            // LIFO 구조: 맨 마지막 인덱스 요소를 지우고 반환
            return list.remove(list.size() - 1);
        }

        public void print() {
            System.out.print("스택 상태: ");
            for (T item : list) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    // Problem 2: 제네릭 메서드 swap
    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Problem 4: 와일드카드 printList
    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Lab6: 제한된 타입 매개변수 클래스
    static class NumberBox<T extends Number> {
        private T number;
        NumberBox(T n) { this.number = n; }
        public double doubleValue() { return number.doubleValue(); }
    }

    static class Lab1 {
        static void run() {
            Box<Integer> intBox = new Box<>(30);
            Box<String> strBox = new Box<>("숫자 30");

            System.out.println("Integer 박스 내용물: " + intBox.getBox());
            System.out.println("String 박스 내용물: " + strBox.getBox());
        }
    }

    static class Lab2 {
        static void run() {
            String[] fruits = {"바나나", "사과", "포도", "딸기"};
            System.out.println("교환 전 배열: " + Arrays.toString(fruits));
            
            // 0번 "바나나"와 3번 "딸기" 교환
            swap(fruits, 0, 3);
            System.out.println("교환 후 배열: " + Arrays.toString(fruits));
        }
    }

    static class Lab3 {
        static void run() {
            Stack<Integer> intStack = new Stack<>();
            intStack.push(3);
            intStack.push(4);
            intStack.push(5);
            intStack.push(6);

            intStack.print();
            
            System.out.println("pop() 된 값: " + intStack.pop()); // 6 탈출
            intStack.print();
        }
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

    static class Lab5 {
        static void run() {
            System.out.println("[제네릭 타입 파라미터 표준 네이밍 관례]");
            System.out.println("1. <T> (Type): 클래스나 인터페이스 설계 시 가장 일반적인 가상 타입 선언");
            System.out.println("2. <E> (Element): 리스트, 셋 등 컬렉션 요소의 타입 지정");
            System.out.println("3. <K, V> (Key, Value): 맵 등 키-밸류 쌍의 타입으로 매핑 지정");
            System.out.println("4. <N> (Number): 숫자형 기본 클래스 제약에 주로 지정");
        }
    }

    static class Lab6 {
        static void run() {
            // NumberBox는 Number 계열(Double, Integer 등)만 가능합니다.
            NumberBox<Double> dBox = new NumberBox<>(3.14);
            // NumberBox<String> sBox = new NumberBox<>("에러"); // [컴파일 에러!] Bounded Type에 어긋남
            System.out.println("NumberBox 값 꺼내기 (doubleValue): " + dBox.doubleValue());
        }
    }
}
