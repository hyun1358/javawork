package week12.day1;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * [예습 파일] Week 12 Day 1 — 소켓 통신 (Server)
 * 실행 후 브라우저에서 http://localhost:8080 으로 접속해보세요.
 */
public class Preview {
    public static void main(String[] args) {
        System.out.println("서버 대기 중... (실행 후 브라우저로 localhost:8080 접속)");
        try (ServerSocket server = new ServerSocket(8080)) {
            // Socket client = server.accept(); // 클라이언트 접속 대기 (블로킹)
            // System.out.println("클라이언트 접속!");
            System.out.println("주석을 풀면 진짜 서버가 됩니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
