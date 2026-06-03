package week10.day3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * [연습 문제 4] 블로킹 큐 맛보기 (생산자-소비자)
 * 문제: ArrayBlockingQueue<Integer>에 값을 넣고 빼는 구조를 작성해보세요.
 */
public class Problem4 {
    public static void main(String[] args) throws InterruptedException
    {
        // TODO
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);

        Thread producer = new Thread(() ->
        {
            for(int i = 0; i < 4; i++)
            {
                try {
                    queue.put(i);
                    System.out.println("생산:" + i + "사이즈:" + queue.size());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(()->
        {
            for(int i = 0; i < 4; i++)
            {
                try {
                    System.out.println("소비: " + i + "사이즈: " + queue.take());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

    }
}
