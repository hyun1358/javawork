package week12.day1;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * [연습 문제 1] 간단한 서버 소켓
 * 문제: 포트번호 9000번으로 ServerSocket을 열고, "서버 실행 중" 메시지를 출력하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        int PORT = 9000;

        try
        {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("서버 실행중");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
