package week08.day5;

/**
 * [학습 예제] Week 08 Day 5 — 제네릭 메서드와 와일드카드
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: 제네릭 메서드 ===");
        Integer[] arr = {1, 2, 3};
        printArray(arr); // 제네릭 메서드 호출

        System.out.println("\n=== Lab2: 타입 제한 (extends) ===");
        NumberBox<Double> nb = new NumberBox<>(3.14);
        System.out.println(nb.get());
    }

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
