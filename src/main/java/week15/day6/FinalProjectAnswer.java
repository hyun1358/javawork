package week15.day6;

import java.io.*;
import java.net.*;

/**
 * [15주차 미니 프로젝트] 채팅 서버 및 클라이언트 (Chat Server & Client)
 * 
 * 문제:
 * 1. ServerSocket을 사용하여 다중 클라이언트 접속을 처리하는 채팅 서버를 구현하세요.
 * 2. 각 클라이언트의 요청은 개별 스레드(Thread)에서 처리되도록 구성하세요.
 * 3. 클라이언트가 서버에 접속하면 환영 메시지를 보내고, 클라이언트가 보낸 메시지를 그대로 반환(Echo)하세요.
 * 4. 이 파일 하나에서 테스트할 수 있도록 main 스레드에서 서버를 띄우고, 별도 스레드에서 클라이언트로 접속하는 로직을 작성하세요.
 *
 * 아래는 위 문제를 해결한 정답 예시(Answer)입니다.
 */
public class FinalProjectAnswer {
    public static void main(String[] args) {
        // [주석] 서버를 백그라운드 스레드에서 실행
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(9999)) {
                System.out.println("[서버] 시작됨. 클라이언트 대기 중... (포트: 9999)");
                // 1회 접속만 테스트하는 간단한 구현
                Socket clientSocket = serverSocket.accept();
                System.out.println("[서버] 클라이언트 접속: " + clientSocket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                out.println("서버에 접속하신 것을 환영합니다!");

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("[서버 수신] " + inputLine);
                    out.println("Echo: " + inputLine); // 에코 반환
                    if ("exit".equalsIgnoreCase(inputLine)) break;
                }
                clientSocket.close();
                System.out.println("[서버] 종료됨.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // 서버가 뜰 시간을 잠깐 줍니다.
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        // [주석] 클라이언트 실행
        System.out.println("\n[클라이언트] 서버에 접속을 시도합니다...");
        try (Socket socket = new Socket("localhost", 9999);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
             
            // 서버의 환영 메시지 수신
            System.out.println("[클라이언트 수신] " + in.readLine());

            // 서버로 메시지 전송
            String[] messages = {"안녕하세요!", "네트워크 프로그래밍 재밌네요.", "exit"};
            for (String msg : messages) {
                System.out.println("[클라이언트 송신] " + msg);
                out.println(msg);
                // 에코 메시지 수신
                System.out.println("[클라이언트 수신] " + in.readLine());
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
