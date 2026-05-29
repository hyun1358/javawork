package week12.day2;

import java.io.*;
import java.net.*;

// Java 11 이전부터 사용되어 오던 전통적인 HttpURLConnection을 이용한 HTTP 요청 예제입니다.
public class Answer3 {
    // 메인 메서드
    public static void main(String[] args) throws Exception {
        // URL 객체를 생성하고 커넥션을 엽니다. HttpURLConnection으로 형변환하여 사용합니다.
        HttpURLConnection conn = (HttpURLConnection) new URL("https://jsonplaceholder.typicode.com/users/1").openConnection();
        
        // 서버로부터 응답받은 HTTP 상태 코드가 200(OK)인지 확인합니다.
        if (conn.getResponseCode() == 200) {
            // 입력 스트림을 열어 BufferedReader로 감싼 뒤, 문자열 형태로 한 줄을 읽어옵니다.
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            System.out.println("내용: " + br.readLine());
        }
        // 사용이 끝난 연결(커넥션)을 종료하여 자원을 해제합니다.
        conn.disconnect();
    }
}
