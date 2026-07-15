package week12.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * [연습 문제 4] 에코 서버 뼈대
 * 문제: 클라이언트가 보내는 메시지를 InputStream으로 읽어들이는 뼈대를 주석으로 설명하세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        int PORT = 9000;
        try(ServerSocket serverSocket = new ServerSocket(PORT); //서버가 포트를 열어서 서버를 오픈
            Socket clientSocket = serverSocket.accept();) // 사용자가 해당 포트로 들어왔는지 확인(안들어오면 무한대기)
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // 클라이언트가 서버한테 보낸 메세지를 받기위해 버퍼사용
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream() , true); // 서버가 클라이언트한테 메세지를 보낼려고 사용하는 프린트롸이터

            String msg = in.readLine(); // 클라이언트가 서버한테 무슨 메세지를 보낸는지 한줄씩 가져옴
            System.out.println("[클라이언트]에서 보낸 메세지: "+msg); // 출력

            System.out.println("[서버]에서 [클라이언트]로 보낸 메세지: "+msg);
            out.println(msg);// 서버가 클라한테 다시 메세지를 보냄

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
