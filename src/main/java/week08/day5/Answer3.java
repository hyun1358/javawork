package week08.day5;

import java.util.ArrayList;

/**
 * 제네릭스를 사용하여 ArrayList 기반의 간단한 스택(Stack) 구조를 구현하는 예제입니다.
 */
public class Answer3 {
    public static void main(String[] args) {
        // String 타입을 저장하는 스택 객체를 생성합니다.
        MyStack<String> s = new MyStack<>();
        // 요소를 스택에 추가합니다. (LIFO - 후입선출)
        s.push("1");
        s.push("2");
        // 마지막에 추가된 "2"가 먼저 꺼내집니다.
        System.out.println(s.pop()); // 2
    }
}

// 제네릭 타입 T를 사용하는 MyStack 클래스입니다.
class MyStack<T> {
    // 내부적으로 데이터를 저장할 ArrayList입니다.
    private ArrayList<T> list = new ArrayList<>();

    // 스택에 요소를 추가합니다. 리스트의 맨 끝에 요소를 추가하게 됩니다.
    public void push(T item) {
        list.add(item);
    }

    // 스택에서 요소를 꺼냅니다. 리스트의 마지막 요소를 삭제하며 반환합니다.
    public T pop() {
        return list.remove(list.size() - 1);
    }
}
