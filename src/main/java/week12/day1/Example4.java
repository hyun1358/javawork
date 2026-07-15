package week12.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * [학습 예제 4] Week 12 Day 1 — 소켓 통신(Socket Programming) 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 4] 소켓 입출력 스트림
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - socket.getOutputStream(): 데이터를 상대방에게 보내는 스트림
 *  - socket.getInputStream():  상대방이 보낸 데이터를 받는 스트림
 *  - PrintWriter(out, true): 자동 flush로 문자열 전송
 *  - BufferedReader.readLine(): 한 줄씩 수신
 *
 * [문제별 학습 목표]
 * - 문제 4: 에코 서버 뼈대 — InputStream/BufferedReader 로 메시지 읽기
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("\n=== Lab 4: 에코 서버 구조 ===");
        int PORT = 9000;

        System.out.println("[서버] 에코 서버가 포트 " + PORT + "에서 대기 중입니다...");

        // try-with-resources 구문을 사용하여 소켓 및 스트림 리소스를 자동으로 닫아줍니다.
        try (ServerSocket serverSocket = new ServerSocket(PORT);
             Socket clientSocket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            System.out.println("[서버] 클라이언트 접속 완료: " + clientSocket.getInetAddress());

            // 1. 클라이언트가 보낸 메시지 한 줄 읽기 (엔터/줄바꿈 기준)
            String msg = in.readLine();
            System.out.println("[서버] 클라이언트가 보낸 메시지: " + msg);

            // 2. 받은 메시지를 그대로 클라이언트에게 다시 돌려보내기 (에코)
            out.println("[에코] " + msg);
            System.out.println("[서버] 클라이언트에게 에코 전송 완료");

        } catch (IOException e) {
            System.err.println("[서버] 예외 발생: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("[서버] 통신이 끝나 소켓이 닫혔으며 프로그램이 종료되었습니다.");
    }
}
