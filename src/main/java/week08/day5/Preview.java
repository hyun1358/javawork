package week08.day5;

/**
 * [예습 파일] Week 08 Day 5 — 제네릭(Generics) 기초
 * 
 * 제네릭은 클래스나 메서드에서 사용할 데이터 타입을 '외부에서 지정'하는 기법입니다.
 * 타입을 미리 정해두지 않고 'T'와 같은 기호로 비워둔 뒤, 
 * 실제 사용할 때 <String>이나 <Integer>처럼 결정합니다.
 * 
 * [제네릭을 쓰는 이유]
 * 1. 타입 안정성: 엉뚱한 타입의 데이터가 들어오는 것을 컴파일 시점에 막아줍니다.
 * 2. 형변환 생략: 데이터를 꺼낼 때 매번 (String) 처럼 강제 형변환을 안 해도 됩니다.
 * 3. 코드 재사용: 하나의 클래스로 여러 타입의 데이터를 처리할 수 있습니다.
 */
public class Preview {
    public static void main(String[] args) {
        // T 자리에 String을 넣어서 문자열 전용 박스를 만듭니다.
        Box<String> strBox = new Box<>();
        strBox.set("안녕하세요");
        String s = strBox.get(); // 형변환 없이 바로 꺼낼 수 있음
        System.out.println("문자열 박스: " + s);

        // T 자리에 Integer를 넣어서 정수 전용 박스를 만듭니다.
        Box<Integer> intBox = new Box<>();
        intBox.set(2026);
        int i = intBox.get();
        System.out.println("숫자 박스: " + i);
    }
}

/**
 * <T> : 'Type'의 약자로, 나중에 결정될 타입을 의미하는 기호입니다.
 * 관례적으로 T(Type), E(Element), K(Key), V(Value) 등을 사용합니다.
 */
class Box<T> {
    private T item;

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }
}
