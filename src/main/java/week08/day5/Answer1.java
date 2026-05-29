package week08.day5;

/**
 * 제네릭스(Generics)를 사용하여 클래스의 타입을 동적으로 지정하는 기본 예제입니다.
 */
public class Answer1 {
    public static void main(String[] args) {
        // Integer 타입으로 MyBox 객체를 생성합니다.
        MyBox<Integer> b = new MyBox<>();
        // 이제 b.val은 Integer 타입으로 취급되므로 정수를 저장할 수 있습니다.
        b.val = 10;
        System.out.println(b.val);
    }
}

// 제네릭 클래스 선언: <T>는 이 클래스가 생성될 때 구체적인 타입으로 대체될 임의의 타입 파라미터입니다.
class MyBox<T> {
    T val;
}
