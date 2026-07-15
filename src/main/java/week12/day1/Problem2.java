package week12.day1;

import java.io.IOException;
import java.net.Socket;

/**
 * [연습 문제 2] 서버에 연결 (Client)
 * 문제: localhost의 9000번 포트로 Socket을 생성하여 접속하는 클라이언트 코드를 작성하세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO

        int PORT = 9000;
        try
        {
            Socket socket = new Socket("localhost",PORT);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
