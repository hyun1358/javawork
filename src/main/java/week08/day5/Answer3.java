package week08.day5;

import java.util.ArrayList;

public class Answer3 {
    public static void main(String[] args) {
        MyStack<String> s = new MyStack<>();
        s.push("1");
        s.push("2");
        System.out.println(s.pop()); // 2
    }
}

class MyStack<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        return list.remove(list.size() - 1);
    }
}
