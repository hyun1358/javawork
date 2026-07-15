package week12.day1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * [학습 예제 3] Week 12 Day 1 — 소켓 통신(Socket Programming) 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 3] accept()
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - serverSocket.accept(): 클라이언트 접속을 기다림 (블로킹)
 *    → 접속이 오면 Socket(연결된 소켓) 반환
 *
 * [문제별 학습 목표]
 * - 문제 3: accept() — 클라이언트 접속 수락 후 "접속 환영!" 출력
 */
public class Example3 {
    public static void main(String[] args) {
        int PORT = 9000;
        System.out.println("=== accept() 구조 예제 ===");
          try (ServerSocket serverSocket = new ServerSocket(PORT))
          {
              Socket clientSocket = serverSocket.accept();
              System.out.println("[서버] 접속 환영! 클라이언트: " + clientSocket.getInetAddress());
          } catch (IOException e) {
              throw new RuntimeException(e);
          }
        System.out.println("accept()는 클라이언트 접속 전까지 실행을 멈추고 기다리는 블로킹 메서드입니다.");
    }
}
