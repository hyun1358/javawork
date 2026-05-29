package week08.day5;

import java.util.ArrayList;
import java.util.List;

/**
 * [연습 문제 3-1 정답 및 이론 해설]
 * 
 * 💡 핵심 이론: 큐(Queue) 자료구조와 FIFO (First-In, First-Out)
 * 
 * 1. 큐의 개념:
 *    - 큐는 먼저 대입된 데이터가 가장 먼저 빠져나가는 "선입선출" 구조의 선형 자료구조입니다.
 *    - 데이터가 한쪽 끝에서 삽입되고(Enqueue), 다른 쪽 반대편 끝에서 삭제(Dequeue)되는 형태를 띱니다.
 * 
 * 2. ArrayList 기반 큐 구현 원리:
 *    - **데이터 추가 (Enqueue)**:
 *      * `list.add(item)` 메서드를 호출하면 데이터가 리스트의 맨 끝(마지막 인덱스)에 추가됩니다. 
 *      * 이는 대기열의 가장 뒤쪽에 새로운 사람이 와서 줄을 서는 것과 같습니다.
 *    - **데이터 삭제 및 반환 (Dequeue)**:
 *      * 리스트에서 가장 오래된 데이터, 즉 대기열의 가장 맨 앞에 서 있는 데이터는 언제나 인덱스 `0`번에 존재합니다.
 *      * 따라서 `list.remove(0)`을 호출하면 0번째에 해당하는 최초 입력 데이터를 안전하게 삭제하면서 꺼낼 수 있습니다.
 *      * 자바의 `ArrayList`는 `remove(0)`이 수행되면 뒤에 있던 모든 데이터들을 알아서 한 칸씩 앞으로 당겨주는 메커니즘을 제공하므로,
 *        이후에 다시 dequeue를 해도 0번 인덱스에서 새로운 맨 앞 데이터를 정확히 꺼낼 수 있게 됩니다.
 */
public class Answer3_1 {
    public static void main(String[] args) {
        // 이미 상세한 주석이 있지만, 추가적인 설명을 달아봅니다. (제네릭스 큐 구현 확인)
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
        // 제네릭 타입 T를 안전하게 저장할 내부 ArrayList 저장소
        private List<T> list = new ArrayList<>();

        /**
         * 큐의 맨 뒤에 데이터를 추가합니다 (Enqueue)
         */
        public void enqueue(T item) {
            // list.add()는 리스트의 마지막 위치에 원소를 추가하므로 큐의 입구 역할을 수행합니다.
            list.add(item);
        }

        /**
         * 큐의 맨 앞(가장 먼저 들어온 0번 인덱스) 데이터를 삭제하며 반환합니다 (Dequeue)
         */
        public T dequeue() {
            // 빈 리스트일 때 remove(0)을 시도하면 IndexOutOfBoundsException이 발생하므로 예외 처리를 해줍니다.
            if (list.isEmpty()) {
                return null;
            }
            // 0번 인덱스의 원소를 제거하며 그 값을 반환합니다.
            return list.remove(0);
        }

        /**
         * 현재 큐에 쌓여 있는 데이터들을 꺼내지 않고 출력합니다.
         */
        public void print() {
            for (T item : list) {
                System.out.println(item);
            }
        }
    }
}
