package week12.day1;

import java.net.ServerSocket;

public class Answer1 {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            System.out.println("9000번 포트 서버 실행 중");
        } catch (Exception e) {
        }
    }
}
