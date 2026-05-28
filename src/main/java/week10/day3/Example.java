package week10.day3;

import java.time.LocalTime;
import java.util.concurrent.*;

/**
 * [학습 예제] Week 10 Day 3 — 스레드 풀 완전 정복
 *
 * ★ 이 파일은 오늘 풀어야 할 연습 문제 5개의 핵심 기술을 모두 담고 있습니다.
 *
 * [문제별 학습 목표]
 * - 문제 1: Executors.newFixedThreadPool(N) + execute() 로 작업 던지기
 * - 문제 2: Callable<T> + submit() + future.get() 으로 결과값 받기
 * - 문제 3: ScheduledExecutorService + scheduleAtFixedRate() 로 주기적 실행
 * - 문제 4: ArrayBlockingQueue<T> 의 put() / take() 로 생산자-소비자 구조 구현
 * - 문제 5: pool.shutdown() 의 목적과 올바른 종료 방법
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1] FixedThreadPool + execute()
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - newFixedThreadPool(N): 스레드 N개를 미리 만들어두는 풀
 *  - execute(Runnable): 결과 반환이 없는 작업을 풀에 던짐
 *  - 스레드가 부족하면 작업은 내부 큐에서 대기함
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 2] Callable + Future
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - Callable<T>: Runnable과 달리 결과값(T)을 return할 수 있음
 *  - submit(callable): 작업을 제출하고 Future<T>를 즉시 돌려줌
 *  - future.get(): 작업 완료를 기다렸다가 결과값을 꺼내옴 (블로킹)
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 3] ScheduledExecutorService
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - newScheduledThreadPool(1): 예약 실행 전용 스레드 풀
 *  - scheduleAtFixedRate(task, initialDelay, period, unit)
 *    → initialDelay 후 처음 실행, 이후 period 간격으로 반복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 4] ArrayBlockingQueue (생산자-소비자 패턴)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - new ArrayBlockingQueue<>(N): 최대 N개 용량의 블로킹 큐
 *  - put(item): 큐가 가득 차면 빈 자리가 생길 때까지 블로킹
 *  - take(): 큐가 비어있으면 데이터가 들어올 때까지 블로킹
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 5] shutdown() — 스레드 풀 종료
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - shutdown()을 호출하지 않으면 JVM이 종료되지 않음!
 *    (스레드 풀의 스레드들이 계속 살아있어 프로세스가 멈추지 않음)
 *  - shutdown(): 현재 대기 중인 모든 작업을 완료한 뒤 종료 예약
 *  - shutdownNow(): 강제 중단 시도 (비권장)
 */
public class Example {
    public static void main(String[] args) throws Exception {

        // ─────────────────────────────────────────────
        // Lab 1: FixedThreadPool + execute() (→ 문제 1 참고)
        // ─────────────────────────────────────────────
        System.out.println("=== Lab 1: FixedThreadPool + execute() ===");
        // 스레드 3개짜리 풀 생성
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            final int num = i;
            pool.execute(() -> {
                System.out.println("작업 " + num + " 실행 → " + Thread.currentThread().getName());
            });
        }
        // ↓ 반드시 shutdown 해야 JVM이 종료됨 (→ 문제 5 핵심)
        pool.shutdown();
        // awaitTermination: 최대 3초간 종료 완료를 대기
        pool.awaitTermination(3, TimeUnit.SECONDS);

        // ─────────────────────────────────────────────
        // Lab 2: Callable + Future (→ 문제 2 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 2: Callable + Future ===");
        ExecutorService pool2 = Executors.newSingleThreadExecutor();

        // Callable<String>: 결과로 String을 반환하는 작업 정의
        Callable<String> task = () -> {
            Thread.sleep(200); // 시뮬레이션 딜레이
            return "작업 완료!";
        };

        Future<String> future = pool2.submit(task); // 작업 제출 → Future 즉시 반환

        System.out.println("결과 기다리는 중...");
        String result = future.get(); // 완료될 때까지 블로킹 대기
        System.out.println("Future 결과: " + result);
        pool2.shutdown();

        // ─────────────────────────────────────────────
        // Lab 3: ScheduledExecutorService (→ 문제 3 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 3: ScheduledExecutorService (3초간 1초마다 출력) ===");
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // 0초 후 시작, 1초 간격으로 반복 실행
        ScheduledFuture<?> scheduledFuture = scheduler.scheduleAtFixedRate(
            () -> System.out.println("현재 시각: " + LocalTime.now()),
            0, 1, TimeUnit.SECONDS
        );

        // 3초 후 스케줄러 중단 (데모용)
        Thread.sleep(3100);
        scheduledFuture.cancel(false); // 현재 실행 중인 작업은 방해하지 않고 예약 취소
        scheduler.shutdown();

        // ─────────────────────────────────────────────
        // Lab 4: ArrayBlockingQueue 생산자-소비자 (→ 문제 4 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 4: ArrayBlockingQueue 생산자-소비자 ===");
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3); // 최대 3개 수용

        // 생산자 스레드: 1~4 를 넣음 (4번째는 자리날 때까지 블로킹됨)
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 4; i++) {
                    queue.put(i);
                    System.out.println("생산: " + i + " (큐 사이즈: " + queue.size() + ")");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 소비자 스레드: 4개를 꺼냄
        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(500); // 잠깐 기다렸다 꺼냄
                for (int i = 0; i < 4; i++) {
                    System.out.println("소비: " + queue.take());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();

        // ─────────────────────────────────────────────
        // Lab 5: shutdown()의 목적 정리 (→ 문제 5 핵심)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 5: shutdown() 이유 ===");
        ExecutorService pool3 = Executors.newFixedThreadPool(2);
        pool3.execute(() -> System.out.println("마지막 작업 실행"));

        // shutdown()을 호출하지 않으면:
        //  → 스레드 풀의 워커 스레드들이 살아있어 JVM이 종료되지 않음
        //  → 프로그램이 끝나지 않고 영원히 대기 상태에 빠짐
        // shutdown()을 호출하면:
        //  → 이미 제출된 작업들은 모두 완료하고, 이후 새 작업 수락을 거부하며 종료됨
        pool3.shutdown();
        System.out.println("pool3 shutdown 완료");
    }
}
