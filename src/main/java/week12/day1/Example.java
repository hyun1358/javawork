package week12.day1;

import java.io.*;
import java.net.*;

/**
 * [학습 예제] Week 12 Day 1 — 소켓 통신(Socket Programming) 완전 정복
 *
 * ★ 이 파일은 오늘 풀어야 할 연습 문제 5개의 핵심 기술을 모두 담고 있습니다.
 *
 * [문제별 학습 목표]
 * - 문제 1: ServerSocket — 포트 9000으로 열고 "서버 실행 중" 출력
 * - 문제 2: Socket(Client) — localhost:9000 으로 접속하는 클라이언트
 * - 문제 3: accept() — 클라이언트 접속 수락 후 "접속 환영!" 출력
 * - 문제 4: 에코 서버 뼈대 — InputStream/BufferedReader 로 메시지 읽기
 * - 문제 5: 멀티스레드 필요성 — 여러 클라이언트를 동시에 처리하는 이유
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1 & 2] ServerSocket vs Socket
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - ServerSocket(port): 서버 역할 — 지정 포트를 열고 대기
 *  - serverSocket.accept(): 클라이언트 접속을 기다림 (블로킹)
 *    → 접속이 오면 Socket(연결된 소켓) 반환
 *  - new Socket("host", port): 클라이언트 역할 — 서버에 접속
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 3 & 4] 소켓 입출력 스트림
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - socket.getOutputStream(): 데이터를 상대방에게 보내는 스트림
 *  - socket.getInputStream():  상대방이 보낸 데이터를 받는 스트림
 *  - PrintWriter(out, true): 자동 flush로 문자열 전송
 *  - BufferedReader.readLine(): 한 줄씩 수신
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 5] 멀티스레드가 필요한 이유
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - serverSocket.accept()는 블로킹 메서드
 *    → 한 클라이언트와 통신하는 동안 다른 클라이언트 접속 불가
 *  - 해결책: 클라이언트 접속마다 새 Thread 생성
 *    → 각 클라이언트는 별도 스레드에서 독립적으로 처리됨
 */
public class Example {
    public static void main(String[] args) throws Exception {

        // ─────────────────────────────────────────────
        // Lab 1 & 2 & 3: ServerSocket + accept + Socket 구조 설명
        // (실제 서버-클라이언트는 별도 프로세스로 실행해야 하므로
        //  여기서는 스레드로 서버/클라이언트를 동시에 시뮬레이션합니다)
        // ─────────────────────────────────────────────
        System.out.println("=== Lab 1 & 2 & 3: ServerSocket + Socket 구조 ===");

        int PORT = 9000;

        // 서버 스레드 (문제 1, 3 참고)
        Thread serverThread = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                System.out.println("[서버] 실행 중 — 포트 " + PORT + " 대기 중...");

                // accept(): 클라이언트 접속을 기다림 (블로킹)
                Socket clientSocket = serverSocket.accept();
                System.out.println("[서버] 접속 환영! 클라이언트: " + clientSocket.getInetAddress());

                // 문제 4: InputStream으로 클라이언트 메시지 읽기
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String received = in.readLine();
                System.out.println("[서버] 수신: " + received);
                out.println("[에코] " + received); // 에코: 받은 메시지 그대로 돌려보냄

                clientSocket.close();
                System.out.println("[서버] 클라이언트 연결 종료");

            } catch (IOException e) {
                System.out.println("[서버] 오류: " + e.getMessage());
            }
        });

        // 클라이언트 스레드 (문제 2 참고)
        Thread clientThread = new Thread(() -> {
            try {
                Thread.sleep(200); // 서버가 먼저 뜨도록 잠깐 대기
                // new Socket("host", port): 서버에 접속
                Socket socket = new Socket("localhost", PORT);
                System.out.println("[클라이언트] 서버 접속 완료: localhost:" + PORT);

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

                out.println("안녕하세요 서버!"); // 메시지 전송

                String echo = in.readLine();
                System.out.println("[클라이언트] 에코 수신: " + echo);

                socket.close();
            } catch (Exception e) {
                System.out.println("[클라이언트] 오류: " + e.getMessage());
            }
        });

        serverThread.start();
        clientThread.start();
        serverThread.join();
        clientThread.join();

        // ─────────────────────────────────────────────
        // Lab 4: 에코 서버 구조 설명 (→ 문제 4 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 4: 에코 서버 구조 ===");
        /*
         * [에코 서버 동작 순서]
         *  1. ServerSocket serverSocket = new ServerSocket(9000);
         *     → 포트 9000 개방
         *
         *  2. Socket clientSocket = serverSocket.accept();
         *     → 클라이언트가 접속할 때까지 블로킹 대기
         *
         *  3. BufferedReader in = new BufferedReader(
         *         new InputStreamReader(clientSocket.getInputStream()));
         *     → 클라이언트로부터 오는 바이트 스트림을 문자(라인)로 변환
         *
         *  4. String msg = in.readLine();
         *     → 클라이언트가 보낸 한 줄 메시지 수신
         *
         *  5. PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
         *     out.println("[에코] " + msg);
         *     → 받은 메시지를 그대로 클라이언트에게 돌려보냄 (에코)
         *
         *  6. clientSocket.close(); serverSocket.close();
         *     → 반드시 연결 종료 (리소스 반환)
         */
        System.out.println("에코 서버: 클라이언트 메시지를 받아 그대로 돌려보내는 구조");

        // ─────────────────────────────────────────────
        // Lab 5: 멀티스레드 필요성 (→ 문제 5 참고)
        // ─────────────────────────────────────────────
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
         *
         * [실무에서는 스레드 풀 사용]
         *  - new Thread() 남발 대신 ExecutorService(FixedThreadPool) 사용
         *  - 스레드 생성/소멸 비용 절감, 최대 동시 연결 수 제한 가능
         */
        System.out.println("단일 스레드: 클라이언트A가 끝나야 클라이언트B 처리 가능 (순차)");
        System.out.println("멀티스레드: 클라이언트마다 별도 스레드 → 동시 처리 가능 (병렬)");
        System.out.println("실무:       ExecutorService(스레드 풀)로 최적화");
    }
}
