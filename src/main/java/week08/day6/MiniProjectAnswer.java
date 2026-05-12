package week08.day6;

import java.util.ArrayList;

public class MiniProjectAnswer {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        stack.push("첫번째");
        stack.push("두번째");
        System.out.println("Stack pop: " + stack.pop()); // 두번째

        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println("Queue dequeue: " + queue.dequeue()); // 1
    }
}

class MyStack<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void push(T t) {
        list.add(t);
    }

    public T pop() {
        if (isEmpty()) return null;
        return list.remove(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

class MyQueue<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void enqueue(T t) {
        list.add(t);
    }

    public T dequeue() {
        if (isEmpty()) return null;
        return list.remove(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
