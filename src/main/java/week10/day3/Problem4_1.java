package week10.day3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * [보충 문제 4_1] 블로킹 큐의 논블로킹 동작 (offer와 poll)
 * 
 * [문제]
 * ArrayBlockingQueue에서 put()과 take()는 공간이 없거나 비었을 때 스레드를 대기(블로킹)시킵니다.
 * 반면 offer()와 poll()은 대기하지 않고 즉시 성공 여부(true/false)나 값(또는 null)을 반환하는 논블로킹 메서드입니다.
 * 
 * 크기가 2인 ArrayBlockingQueue<String>을 생성하고 아래 요구사항을 구현하세요.
 * 1. offer("A"), offer("B"), offer("C")를 연속해서 수행하고, 각각의 반환값(true 또는 false)을 출력하여 세 번째 값("C")이 실패(false)하는지 확인하세요.
 * 2. poll()을 세 번 호출하여 꺼내온 값을 출력하고, 세 번째 poll() 호출 시 큐가 비어 null이 반환되는지 확인하세요.
 */
public class Problem4_1 {
    public static void main(String[] args) {
        // TODO: offer()와 poll()을 사용한 논블로킹 큐 제어를 구현하세요.

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

        System.out.println(queue.offer("A"));
        System.out.println(queue.offer("B"));
        System.out.println(queue.offer("C"));

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }
}
