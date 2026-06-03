package week10.day3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * [실습 4] ArrayBlockingQueue 생산자-소비자 패턴 (Problem 4 연계)
 * 
 * 비유: "공간이 딱 3개뿐인 빵 진열대"
 * 생산자 스레드는 빵을 만들어 올리고, 소비자 스레드는 빵을 가져갑니다.
 * 만약 진열대가 꽉 차면 생산자는 더 올리지 못하고 대기(put 블로킹)하고, 
 * 진열대가 텅 비면 소비자는 빵이 올 때까지 기다립니다(take 블로킹). 
 * 자물쇠 없이도 안전한 멀티스레드 대기 큐 구조입니다.
 */
public class Example4 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== [실습 4] ArrayBlockingQueue 생산자-소비자 예제 ===");
        
        // 최대 3개의 빵만 수용할 수 있는 블로킹 큐 생성
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);

        // 생산자 스레드: 1~4까지 빵을 만듦 (4번째는 자리가 날 때까지 대기해야 함)
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 4; i++) {
                    queue.put(i); // 가득 차면 자리가 생길 때까지 자동 대기
                    System.out.println("생산: " + i + " (큐 현재 적재량: " + queue.size() + ")");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 소비자 스레드: 4개의 빵을 야금야금 먹어 치움
        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(500); // 생산자가 빵을 먼저 만들 때까지 아주 잠깐 대기
                for (int i = 0; i < 4; i++) {
                    System.out.println("소비: " + queue.take()); // 비어있으면 빵이 올 때까지 자동 대기
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
        
        producer.join();
        consumer.join();
    }
}
