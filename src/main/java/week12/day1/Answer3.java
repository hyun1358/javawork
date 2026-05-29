package week12.day1;

import java.net.ServerSocket;
import java.net.Socket;

// 서버 측 소켓의 accept() 메서드가 가지는 블로킹(Blocking) 특성을 설명하는 예제입니다.
public class Answer3 {
    // 메인 메서드
    public static void main(String[] args) {
        /*
         * accept() 메서드는 클라이언트의 연결 요청이 들어올 때까지 현재 스레드의 실행을 일시 정지(블로킹)합니다.
         * 연결이 들어오면 대기를 풀고 클라이언트와 통신할 수 있는 일반 Socket 객체를 반환합니다.
         */
        System.out.println("서버의 accept()는 클라이언트가 올 때까지 대기(Block)합니다.");
        // try(ServerSocket s = new ServerSocket(9000)) {
        //     Socket c = s.accept(); // 여기서 프로그램이 대기함
        //     System.out.println("클라이언트 접속!"); // 접속 시에만 실행됨
        // } catch(Exception e){}
    }
}
