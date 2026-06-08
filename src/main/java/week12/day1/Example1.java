package week12.day1;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * [학습 예제 1] Week 12 Day 1 — 소켓 통신(Socket Programming) 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1] ServerSocket
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - ServerSocket(port): 서버 역할 — 지정 포트를 열고 대기
 *
 * [문제별 학습 목표]
 * - 문제 1: ServerSocket — 포트 9000으로 열고 "서버 실행 중" 출력
 */
public class Example1 {
    public static void main(String[] args) {
        int PORT = 9000;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("[서버] 실행 중 — 포트 " + PORT + " 대기 중...");
        } catch (IOException e) {
            System.out.println("[서버] 오류: " + e.getMessage());
        }
    }
}
