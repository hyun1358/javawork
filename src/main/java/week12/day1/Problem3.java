package week12.day1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * [연습 문제 3] 서버에서 클라이언트의 접속 받기
 * 문제: ServerSocket의 accept()를 통해 클라이언트 접속을 받고 "접속 환영!"을 출력하세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        int PORT = 9000;
        try(ServerSocket serverSocket = new ServerSocket(PORT))
        {
            Socket socket = serverSocket.accept();
            System.out.println("접속 환영"+socket.getInetAddress());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
