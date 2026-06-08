package week12.day1;

import java.net.Socket;

/**
 * [학습 예제 2] Week 12 Day 1 — 소켓 통신(Socket Programming) 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 2] Socket
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - new Socket("host", port): 클라이언트 역할 — 서버에 접속
 *
 * [문제별 학습 목표]
 * - 문제 2: Socket(Client) — localhost:9000 으로 접속하는 클라이언트
 */
public class Example2 {
    public static void main(String[] args) {
        int PORT = 9000;
        try (Socket socket = new Socket("localhost", PORT)) {
            System.out.println("[클라이언트] 서버 접속 완료: localhost:" + PORT);
        } catch (Exception e) {
            System.out.println("[클라이언트] 오류: " + e.getMessage());
        }
    }
}
