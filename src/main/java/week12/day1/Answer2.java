package week12.day1;

import java.net.Socket;

public class Answer2 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 9000)) {
            System.out.println("서버 접속 성공");
        } catch (Exception e) {
            System.out.println("서버가 열려있지 않아 접속 실패");
        }
    }
}
