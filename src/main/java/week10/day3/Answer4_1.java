package week10.day3;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * [보충 문제 4_1 정답] 블로킹 큐의 논블로킹 동작 (offer와 poll)
 */
public class Answer4_1 {
    public static void main(String[] args) {
        // 1. 크기가 2인 큐 생성
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

        // 2. offer()를 이용한 데이터 삽입 및 결과 확인
        System.out.println("offer(\"A\") 결과: " + queue.offer("A")); // true
        System.out.println("offer(\"B\") 결과: " + queue.offer("B")); // true
        System.out.println("offer(\"C\") 결과: " + queue.offer("C")); // false (큐가 가득 참)

        System.out.println("--- 데이터 꺼내기 시작 ---");

        // 3. poll()을 이용한 데이터 획득 및 결과 확인
        System.out.println("첫 번째 poll(): " + queue.poll()); // A
        System.out.println("두 번째 poll(): " + queue.poll()); // B
        System.out.println("세 번째 poll(): " + queue.poll()); // null (큐가 비어 있음)
    }
}
