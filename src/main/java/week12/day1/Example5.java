package week12.day1;

/**
 * [학습 예제 5] Week 12 Day 1 — 소켓 통신(Socket Programming) 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 5] 멀티스레드가 필요한 이유
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - serverSocket.accept()는 블로킹 메서드
 *    → 한 클라이언트와 통신하는 동안 다른 클라이언트 접속 불가
 *  - 해결책: 클라이언트 접속마다 새 Thread 생성
 *    → 각 클라이언트는 별도 스레드에서 독립적으로 처리됨
 *
 * [문제별 학습 목표]
 * - 문제 5: 멀티스레드 필요성 — 여러 클라이언트를 동시에 처리하는 이유
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n=== Lab 5: 멀티스레드가 필요한 이유 ===");
        /*
         * [단일 스레드 서버의 문제점]
         *  - accept() → 클라이언트A와 통신(readLine 블로킹) → 클라이언트B가 접속해도 처리 불가
         *  - 클라이언트A가 연결을 끊어야만 클라이언트B를 받을 수 있음 (순차 처리)
         *
         * [멀티스레드 서버 해결책]
         *  while (true) {
         *      Socket client = serverSocket.accept();
         *      // 클라이언트마다 새 스레드 할당
         *      new Thread(() -> handleClient(client)).start();
         *  }
         *  → 각 클라이언트는 독립 스레드에서 동시에 처리됨
         *  → 클라이언트A가 긴 작업 중에도 클라이언트B 즉시 접속 가능
         */
        System.out.println("단일 스레드: 클라이언트A가 끝나야 클라이언트B 처리 가능 (순차)");
        System.out.println("멀티스레드: 클라이언트마다 별도 스레드 → 동시 처리 가능 (병렬)");
        System.out.println("실무:       ExecutorService(스레드 풀)로 최적화");
    }
}
