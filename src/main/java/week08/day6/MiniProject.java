package week08.day6;

import java.util.ArrayList;
import java.util.List;

/**
 * [미니 프로젝트] Week 08 Day 6 — 제네릭 자료구조 라이브러리 (실습용)
 * <p>
 * 가이드(MiniProjectGuide.java)를 참조하여 제네릭 Stack과 Queue를 구현하세요.
 */
public class MiniProject {
    public static void main(String[] args)
    {
        // TODO: MyStack과 MyQueue 객체를 생성하여 동작을 검증하세요.

        MyStack<String> mystack = new MyStack<>();
        mystack.push("사과");
        mystack.push("바나나");
        mystack.push("포도");
        mystack.push("딸기");

        mystack.isEmpty();

        System.out.println("MyStack pop(): " + mystack.pop());
        System.out.println("MyStack pop(): " + mystack.pop());
        System.out.println("MyStack pop(): " + mystack.pop());
        System.out.println("MyStack pop(): " + mystack.pop());

        mystack.isEmpty();

        MyQueue<Integer> myQueue = new MyQueue<>();

        myQueue.enqueue(10);
        myQueue.enqueue(20);
        myQueue.enqueue(30);
        myQueue.enqueue(40);
        myQueue.enqueue(50);

        myQueue.isEmpty();

        System.out.println("myQueue dequeue(): " + myQueue.dequeue());
        System.out.println("myQueue dequeue(): " + myQueue.dequeue());
        System.out.println("myQueue dequeue(): " + myQueue.dequeue());
        System.out.println("myQueue dequeue(): " + myQueue.dequeue());
        System.out.println("myQueue dequeue(): " + myQueue.dequeue());

        myQueue.isEmpty();
    }

    static class MyStack<T>
    {
        List<T> list = new ArrayList<>();

        public void push(T element)
        {
            list.add(element);
        }

        public T pop()
        {
            if(list.isEmpty())
            {
                System.out.println("비어있어서 값을 못 꺼내옵니다.");
                return null;
            }
                return list.remove(list.size()-1);
        }

        public Boolean isEmpty()
        {
            return list.isEmpty();
        }
    }

    static class MyQueue<T>
    {
        List<T> list = new ArrayList<>();

        public void enqueue(T element)
        {
            list.add(element);
        }

        public T dequeue()
        {
            if(list.isEmpty())
            {
                System.out.println("비어있어 가져올 값이 없습니다.");
                return null;
            }

            return list.remove(0);
        }

        public Boolean isEmpty()
        {
            return list.isEmpty();
        }
    }
}
// TODO: MyStack<T>, MyQueue<T> 클래스 작성
