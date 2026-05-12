package week08.day5;

/**
 * [예습 파일] Week 08 Day 5 — 제네릭 (Generics) 기초
 */
public class Preview {
    public static void main(String[] args) {
        // T 자리에 원하는 타입을 넣어서 객체를 생성합니다.
        Box<String> strBox = new Box<>();
        strBox.set("Hello");
        System.out.println(strBox.get());

        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println(intBox.get());
    }
}

// 타입 파라미터 T
class Box<T> {
    private T item;

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }
}
