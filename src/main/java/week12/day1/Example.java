package week12.day1;

import java.io.*;
import java.net.*;

/**
 * [학습 예제] Week 12 Day 1 — 에코 서버와 클라이언트 구조
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab: 소켓 클라이언트 구조 ===");
        try {
            // www.google.com 의 80포트로 접속 (실제 HTTP 요청)
            Socket socket = new Socket("www.google.com", 80);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("GET / HTTP/1.1\r\nHost: www.google.com\r\n\r\n");
            System.out.println("응답: " + in.readLine());

            socket.close();
        } catch (Exception e) {
            System.out.println("네트워크 연결 실패");
        }
    }
}
