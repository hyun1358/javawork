package week12.day1;

import java.io.*;
import java.net.*;

/**
 * [학습 예제] Week 12 Day 1 — 에코 서버와 클라이언트 구조
 * 
 * [학습 핵심 이론: 메아리(Echo) 주고받기 프로토콜]
 * 1. 입출력 버퍼 스트림 필터:
 *    - 소켓에서 흘러나오는 원시 바이트 스트림을 한 글자씩 읽으면 엄청나게 느리므로, 한 글자씩이 아닌 문장 단위(`readLine()`)로 시원하게 읽고 쓸 수 있는 `BufferedReader`와 `PrintWriter`를 필터로 결합합니다.
 * 
 * 2. 동기식 블로킹(Blocking)의 치명적 한계:
 *    - 서버가 한 명의 클라이언트 소켓과 연결되어 데이터를 주고받는 동안에는 실행 흐름이 꽉 묶여 있어, 두 번째 클라이언트가 접속을 시도해도 전혀 응답해 주지 못합니다.
 *    - 이 문제를 극복하기 위해 실제 상용 네트워크 서버는 클라이언트 접속 시마다 새로운 스레드를 띄워 일대일 전담 배정하는 멀티스레드 소켓 서버 아키텍처를 필수로 구현합니다.
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
