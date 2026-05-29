package week12.day1;

import java.net.Socket;

// Socket을 사용하여 특정 서버와 포트에 접속(연결)하는 클라이언트 측 예제입니다.
public class Answer2 {
    // 메인 메서드
    public static void main(String[] args) {
        // "localhost"(내 컴퓨터)의 9000번 포트로 연결을 시도하는 Socket을 생성합니다.
        try (Socket socket = new Socket("localhost", 9000)) {
            // 연결이 성공적으로 이루어지면 아래 메시지를 출력합니다.
            System.out.println("서버 접속 성공");
        } catch (Exception e) {
            // 해당 포트에 서버가 열려있지 않거나 네트워크 문제가 발생하면 예외가 발생합니다.
            System.out.println("서버가 열려있지 않아 접속 실패");
        }
    }
}
