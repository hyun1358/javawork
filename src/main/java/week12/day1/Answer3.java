package week12.day1;

import java.net.ServerSocket;
import java.net.Socket;

public class Answer3 {
    public static void main(String[] args) {
        System.out.println("서버의 accept()는 클라이언트가 올 때까지 대기(Block)합니다.");
        // try(ServerSocket s = new ServerSocket(9000)) {
        //     Socket c = s.accept();
        //     System.out.println("클라이언트 접속!");
        // } catch(Exception e){}
    }
}
