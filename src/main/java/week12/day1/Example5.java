package week12.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

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
        System.out.println("\n=== Lab 5: 멀티스레드 에코/웹 서버 ===");
        int PORT = 9000;

        System.out.println("[서버] 멀티스레드 서버가 포트 " + PORT + "에서 대기 중입니다...");
        System.out.println("[안내] 서버를 종료하려면 콘솔이나 터미널에서 Ctrl+C를 누르세요.\n");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            // 무한 루프를 돌며 여러 클라이언트의 접속을 계속해서 받습니다.
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("[서버] 새 클라이언트 접속 완료: " + clientSocket.getInetAddress());

                // 클라이언트 접속이 있을 때마다 독립된 스레드를 새로 시작합니다. (병렬 처리)
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("[서버] 서버 소켓 에러: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 개별 클라이언트를 전담하여 통신을 수행하는 메서드입니다.
     * 이 메서드는 메인 스레드가 아닌, 새로 생성된 독립된 스레드 내에서 실행됩니다.
     */
    private static void handleClient(Socket socket) {
        // 현재 실행 중인 스레드의 이름을 가져옵니다 (예: Thread-0, Thread-1 ...)
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] 클라이언트 데이터 처리 시작");

        try (Socket clientSocket = socket;
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            // 클라이언트로부터 들어온 한 줄 메시지 읽기
            String msg = in.readLine();
            System.out.println("[" + threadName + "] 수신 메시지: " + msg);

            if (msg != null) {
                // 💡 [HTTP/1.1 정식 규격 적용] 
                // 크롬 브라우저와 curl이 에러 없이 깔끔하게 웹서버로 인식할 수 있게 규격 헤더를 전송합니다.
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/plain; charset=UTF-8");
                out.println(); // 헤더와 본문을 구분해 주는 필수 빈 줄!

                // 본문 전송 (어느 스레드가 응답했는지 이름을 붙여 보냅니다)
                out.println("[에코 서버 - " + threadName + "] " + msg);
            }

            System.out.println("[" + threadName + "] 처리 완료 및 소켓 연결 종료");

        } catch (IOException e) {
            System.err.println("[" + threadName + "] 클라이언트 처리 중 예외 발생: " + e.getMessage());
        }
    }
}
