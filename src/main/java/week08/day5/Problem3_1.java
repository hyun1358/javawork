package week08.day5;

import java.util.ArrayList;
import java.util.List;

/**
 * [연습 문제 3-1] 제네릭 큐 (Queue)
 * 
 * 💡 이론 소개: 큐 (Queue) 와 FIFO (선입선출)
 * 
 *   - 앞서 연습 문제 3번에서 접한 '스택(Stack)'이 마지막에 들어간 데이터가 먼저 나오는 구조(LIFO)였다면,
 *     '큐(Queue)'는 **먼저 들어간 데이터가 가장 먼저 나오는 선입선출(FIFO, First In First Out)** 구조입니다.
 *   - 비유하자면 맛집의 웨이팅 대기열이나 일렬로 뚫려 있는 터널과 같습니다.
 * 
 * 📝 문제:
 *   내부적으로 ArrayList를 활용하여 아래의 기능을 제공하는 제네릭 Queue<T>를 완성하세요.
 *   1. enqueue(T item): 큐의 맨 뒤에 데이터를 추가합니다.
 *   2. dequeue(): 큐의 맨 앞(가장 먼저 들어온) 데이터를 꺼내고 리스트에서 완전히 제거합니다. (비어있으면 null 반환)
 *   3. print(): 현재 큐에 쌓여있는 모든 원소를 순서대로 출력합니다.
 */
public class Problem3_1 {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        
        // 큐에 순서대로 데이터 넣기 (10 -> 20 -> 30)
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        
        System.out.println("--- 현재 Queue 원소 출력 (기대값: 10, 20, 30) ---");
        q.print();
        
        // FIFO 방식이므로 가장 먼저 넣은 10이 꺼내져야 합니다.
        System.out.println("\n첫 번째 Dequeue 수행: " + q.dequeue()); // 기대값: 10
        System.out.println("두 번째 Dequeue 수행: " + q.dequeue()); // 기대값: 20
        
        System.out.println("\n--- 꺼낸 후 Queue 원소 출력 (기대값: 30) ---");
        q.print();
    }

    static class Queue<T> {
        private List<T> list = new ArrayList<>();

        // TODO: 1. enqueue 메서드를 완성하세요.
        public void enqueue(T item)
        {
            list.add(item);
        }

        // TODO: 2. dequeue 메서드를 완성하세요.
        // 힌트: 가장 먼저 들어온 데이터는 언제나 리스트의 '0'번 인덱스에 저장되어 있습니다.
        public T dequeue()
        {
            return list.remove(0);
        }

        // TODO: 3. print 메서드를 완성하세요.
        public void print()
        {
            for(T item : list)
            {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
