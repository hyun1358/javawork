package week08.day5;

import java.util.ArrayList;
import java.util.List;

/**
 * [연습 문제 3] 제네릭 스택
 * 문제: ArrayList를 감싸서 push(), pop() 기능을 제공하는 제네릭 Stack<T>를 구현하세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        Stack<Integer> s = new Stack<>();
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.pop();
        s.print();
    }
    static class Stack<T>
    {
        T item;
        List<T> list = new ArrayList<>();

        void push(T item)
        {
            list.add(item);
        }

        void pop()
        {
            int index = list.size()-1;
            list.remove(index);
        }

        void print()
        {
            for(T item : list)
            {
                System.out.println(item);
            }
        }
    }

}
