package week10.day3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * [보충 문제 4_2] 다중 생산자 - 단일 소비자 패턴 구현하기
 * 
 * [문제]
 * 실무에서는 여러 스레드가 동시에 큐에 데이터를 밀어 넣고(생산자들), 
 * 다른 백그라운드 스레드가 이를 빼내어 처리(소비자)하는 구조가 흔합니다.
 * 
 * 크기가 3인 ArrayBlockingQueue<Integer>를 생성하세요.
 * 그리고 아래 스레드들을 구성하여 작동시키세요.
 * 1. 생산자 스레드 1: 큐에 1, 2, 3을 순차적으로 put() 합니다.
 * 2. 생산자 스레드 2: 큐에 4, 5, 6을 순차적으로 put() 합니다.
 * 3. 소비자 스레드 1: 큐에서 총 6번 take()를 수행하여 값을 꺼내 화면에 출력합니다.
 * 
 * 모든 스레드를 start() 시키고 join()을 통해 메인 스레드에서 완료를 대기하도록 작성하세요.
 */
public class Problem4_2 {
    public static void main(String[] args) throws InterruptedException
    {
        // TODO: 다중 생산자(2명)와 단일 소비자(1명)가 크기 3인 큐를 공유하여 동시성 제어를 수행하는 코드를 작성하세요.
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        Thread producer1 = new Thread(()->
        {
            try {
                queue.put(1);
                queue.put(2);
                queue.put(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread producer2 = new Thread(()->
        {
            try {
                queue.put(4);
                queue.put(5);
                queue.put(6);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(()->
        {
            try
            {
                for(int i = 0; i < 6; i++)
                {
                    System.out.println(queue.take());
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });

        producer1.start();
        producer2.start();
        consumer.start();

        producer1.join();
        producer2.join();
        consumer.join();

    }
}
