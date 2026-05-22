package week08.day6;

import java.util.ArrayList;

/**
 * [미니 프로젝트 정답 및 상세 해설]
 * 
 * 💡 핵심 학습 주제: 제네릭(Generics)을 활용한 직접 자료구조 구현 (Stack & Queue)
 * 
 * 이 파일은 내부적으로 `ArrayList`를 저장소로 활용하여, 
 * 범용적인 타입을 모두 소화할 수 있는 제네릭 자료구조 MyStack<T>와 MyQueue<T>를 직접 구현한 결과입니다.
 * 
 * -------------------------------------------------------------
 * 1. 제네릭 타입 파라미터 <T>의 역할
 * -------------------------------------------------------------
 *   - `class MyStack<T>`에서 `<T>`는 가상의 타입 매개변수입니다.
 *   - 객체를 생성할 때 `new MyStack<String>()`이나 `new MyStack<Integer>()`처럼 타입을 지정하면,
 *     클래스 내부의 모든 `T`가 지정된 구체적 타입(`String`, `Integer`)으로 안전하게 변환됩니다.
 *   - 이로 인해 여러 타입에 대해 개별 클래스를 복제하지 않고도 단 하나의 클래스로 모든 타입의 안전성을 유지할 수 있습니다.
 * 
 * -------------------------------------------------------------
 * 2. ArrayList 기반 자료구조 구현 원리
 * -------------------------------------------------------------
 *   - ArrayList는 순서가 유지되고 크기가 동적으로 늘어나는 대표적인 동적 배열 리스트 자료구조입니다.
 *   - **MyStack (LIFO)**:
 *     * 데이터를 넣을 때는 끝에 차곡차곡 붙입니다 (`list.add(t)`).
 *     * 꺼낼 때는 **가장 마지막 인덱스**의 원소를 찾아서 삭제하며 반환합니다 (`list.remove(list.size() - 1)`).
 *   - **MyQueue (FIFO)**:
 *     * 데이터를 넣을 때는 끝에 차곡차곡 붙입니다 (`list.add(t)`).
 *     * 꺼낼 때는 **가장 처음 인덱스인 0번** 원소를 삭제하며 반환합니다 (`list.remove(0)`).
 */
public class MiniProjectAnswer {
    public static void main(String[] args) {
        
        System.out.println("--- MyStack<String> 동작 테스트 ---");
        // String 타입을 안전하게 저장하는 Stack 인스턴스 생성
        MyStack<String> stack = new MyStack<>();
        stack.push("첫번째");
        stack.push("두번째");
        stack.push("세번째");
        
        // LIFO 방식이므로 세번째 -> 두번째 -> 첫번째 순서로 꺼내져야 합니다.
        System.out.println("Stack pop: " + stack.pop()); // 세번째
        System.out.println("Stack pop: " + stack.pop()); // 두번째
        System.out.println("Stack pop: " + stack.pop()); // 첫번째
        System.out.println("Stack isEmpty?: " + stack.isEmpty()); // true
        
        System.out.println("\n--- MyQueue<Integer> 동작 테스트 ---");
        // Integer 타입을 안전하게 저장하는 Queue 인스턴스 생성
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        // FIFO 방식이므로 10 -> 20 -> 30 순서로 꺼내져야 합니다.
        System.out.println("Queue dequeue: " + queue.dequeue()); // 10
        System.out.println("Queue dequeue: " + queue.dequeue()); // 20
        System.out.println("Queue dequeue: " + queue.dequeue()); // 30
        System.out.println("Queue isEmpty?: " + queue.isEmpty()); // true
    }
}

/**
 * 🥞 직접 구현한 제네릭 Stack 클래스 (LIFO)
 * @param <T> 저장할 원소의 제네릭 타입
 */
class MyStack<T> {
    // 다양한 타입을 유연하게 담기 위해 내부 저장소로 ArrayList<T>를 선언합니다.
    private ArrayList<T> list = new ArrayList<>();

    /**
     * 스택의 맨 위에 데이터를 추가합니다 (끝자리에 추가)
     */
    public void push(T t) {
        // ArrayList의 add() 메서드는 항상 리스트의 가장 끝에 데이터를 추가합니다.
        list.add(t);
    }

    /**
     * 스택의 맨 위(가장 마지막에 들어온 데이터)를 꺼내서 제거하고 반환합니다.
     */
    public T pop() {
        // 비어있는 상태에서 pop을 시도하면 예외 방지를 위해 null을 반환합니다.
        if (isEmpty()) {
            return null;
        }
        // 가장 마지막 요소의 인덱스는 (전체 크기 - 1)입니다.
        // remove(index) 메서드는 지정된 위치의 값을 리스트에서 완전히 지우면서 동시에 그 값을 리환합니다.
        return list.remove(list.size() - 1);
    }

    /**
     * 스택이 완전히 비어있는지 확인합니다.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

/**
 * 🚇 직접 구현한 제네릭 Queue 클래스 (FIFO)
 * @param <T> 저장할 원소의 제네릭 타입
 */
class MyQueue<T> {
    // 스택과 마찬가지로 내부 저장소는 ArrayList<T>로 유연하게 설정합니다.
    private ArrayList<T> list = new ArrayList<>();

    /**
     * 대기열의 맨 끝에 데이터를 추가합니다 (줄 서기)
     */
    public void enqueue(T t) {
        // ArrayList의 add() 메서드로 리스트 끝에 붙이면 대기열 뒤에 서는 것과 같습니다.
        list.add(t);
    }

    /**
     * 대기열의 맨 앞(가장 먼저 들어온 데이터)을 꺼내서 제거하고 반환합니다.
     */
    public T dequeue() {
        // 비어있는 상태에서 dequeue를 시도하면 null을 반환합니다.
        if (isEmpty()) {
            return null;
        }
        // 가장 먼저 들어온 데이터는 언제나 리스트의 가장 첫 번째 공간인 '0번 인덱스'에 자리잡고 있습니다.
        // remove(0)을 호출하면 맨 앞 요소를 지우면서 그 값을 가져옵니다. 
        // ArrayList의 특성상 나머지 요소들은 자동으로 한 칸씩 앞으로 밀려나 대기하게 됩니다.
        return list.remove(0);
    }

    /**
     * 큐가 완전히 비어있는지 확인합니다.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
