package week10.day3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * [예습 파일] Week 10 Day 3 — 스레드 풀 (ExecutorService)
 * 
 * [핵심 개념: 고성능 스레드 관리 인프라]
 * 1. 스레드 무한 생성의 위험성:
 *    - 스레드는 생성될 때마다 시스템 커널 영역의 자원과 스택 영역(약 1MB) 메모리를 독점 소모하는 매우 무거운 객체입니다.
 *    - 대량 요청 발생 시 스레드를 계속 생성(`new Thread()`)하면 결국 서버의 메모리가 고갈되며 급작스러운 서버 정지를 일으킵니다.
 * 
 * 2. 스레드 풀 (Thread Pool)의 대안:
 *    - 정해진 고정 개수의 스레드들을 메모리에 미리 도란도란 띄워 두고 대기시킵니다.
 *    - 작업 큐(Task Queue)에 요청이 순차적으로 들어오면 놀고 있는 스레드가 이를 하나씩 꺼내 일하고, 일이 끝나면 스레드를 죽이지 않고 다시 풀에 반환해 재사용하는 초고성능 스레드 관리 아키텍처입니다.
 */
public class Preview {
    public static void main(String[] args) {
        // 스레드 2개만 생성해서 풀에 넣어둠
        ExecutorService pool = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            pool.execute(() -> {
                System.out.println("작업 " + taskId + " 실행 중: " + Thread.currentThread().getName());
            });
        }

        pool.shutdown(); // 작업 끝나면 풀 종료 예약
    }
}
