package week10.day3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * [보충 문제 4_2 정답] 다중 생산자 - 단일 소비자 패턴 구현하기
 */
public class Answer4_2 {
    public static void main(String[] args) throws InterruptedException {
        // 1. 크기가 3인 공유 대기 큐 생성
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        // 2. 생산자 스레드 1 (1, 2, 3 생산)
        Thread producer1 = new Thread(() -> {
            try {
                for (int i = 1; i <= 3; i++) {
                    queue.put(i);
                    System.out.println("생산자 1 생산 -> " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 3. 생산자 스레드 2 (4, 5, 6 생산)
        Thread producer2 = new Thread(() -> {
            try {
                for (int i = 4; i <= 6; i++) {
                    queue.put(i);
                    System.out.println("생산자 2 생산 -> " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 4. 소비자 스레드 (총 6번 소비)
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 6; i++) {
                    int value = queue.take();
                    System.out.println("소비자 소비 <- " + value);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 5. 스레드 시작
        producer1.start();
        producer2.start();
        consumer.start();

        // 6. 스레드 종료 대기
        producer1.join();
        producer2.join();
        consumer.join();

        System.out.println("모든 생산 및 소비 작업이 성공적으로 종료되었습니다.");
    }
}
