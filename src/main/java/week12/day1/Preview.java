package week12.day1;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * [예습 파일] Week 12 Day 1 — 소켓 통신 (Server)
 * 
 * [핵심 개념: 네트워크 끝점 간의 연결과 소켓]
 * 1. 소켓(Socket) 통신의 기본 메커니즘:
 *    - 네트워크상에서 컴퓨터 프로세스 두 개가 서로 지속적으로 데이터를 양방향으로 주고받기 위한 통신의 시작과 끝점(Endpoint)을 의미합니다.
 * 
 * 2. ServerSocket vs Socket:
 *    - ServerSocket: 특정 포트(예: 8080)를 선점하고 지키면서, 외부 클라이언트가 통신을 요청해 오기를 묵묵히 기다리는 수신 대기 장치입니다 (`.accept()`에서 blocking 대기).
 *    - Socket: 클라이언트와 서버가 일대일로 주소를 결합해 실제로 데이터 스트림(InputStream / OutputStream)을 뿜어내며 소통하는 실질적인 대화용 통로 객체입니다.
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
