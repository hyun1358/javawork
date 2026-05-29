package week10.day3;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 생산자-소비자 패턴에 유용한 ArrayBlockingQueue 사용 예제입니다.
 */
public class Answer4 {
    public static void main(String[] args) throws Exception {
        // 최대 5개의 요소를 저장할 수 있는 스레드 안전한 큐를 생성합니다.
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        
        // put()은 큐에 데이터를 삽입합니다. (큐가 꽉 찼다면 공간이 생길 때까지 대기합니다.)
        // 이를 통해 '생산' 작업을 수행합니다.
        queue.put(100); 
        
        // take()는 큐에서 데이터를 꺼냅니다. (큐가 비어있다면 데이터가 들어올 때까지 대기합니다.)
        // 이를 통해 '소비' 작업을 수행합니다.
        System.out.println("소비: " + queue.take()); 
    }
}
