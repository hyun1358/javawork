package week12.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * [연습 문제 5] 스레드 적용 필요성
 * 문제: 여러 클라이언트를 동시에 처리하려면 소켓 통신에 왜 스레드가 필요한지 설명하세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        try(ServerSocket serverSocket = new ServerSocket(9000);)
        {

            while (true)
            {
                Socket client = serverSocket.accept();
                new Thread(() -> handleClient(client)).start();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    static void handleClient(Socket socket)
    {
        System.out.print("["+Thread.currentThread().getName()+"]");
        try(Socket client = socket)
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream());

            String msg = in.readLine();
            System.out.println(msg);

            out.println(msg);
            System.out.println("클라로 다시 보냄");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
