package week10.day3;

import java.util.concurrent.ArrayBlockingQueue;

public class Answer4 {
    public static void main(String[] args) throws Exception {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        queue.put(100); // 생산
        System.out.println("소비: " + queue.take()); // 소비
    }
}
