package week12.day2;

import java.net.URI;
import java.net.http.*;

// Java 11부터 도입된 HttpClient를 사용하여 웹 API(HTTP)를 호출하는 예제입니다.
public class Answer1 {
    // 메인 메서드
    public static void main(String[] args) throws Exception {
        // HttpClient 인스턴스를 기본 설정으로 생성합니다.
        HttpClient c = HttpClient.newHttpClient();
        
        // 요청(Request) 객체를 빌더를 통해 생성합니다. 대상 URI를 설정합니다.
        HttpRequest r = HttpRequest.newBuilder()
                                   .uri(URI.create("https://jsonplaceholder.typicode.com/users/1"))
                                   .build();
        
        // 클라이언트를 사용해 요청을 전송하고, 응답(Response) 본문을 문자열(String)로 받아오도록 설정합니다.
        // 받아온 응답 객체에서 body()를 호출하여 내용을 출력합니다.
        System.out.println(c.send(r, HttpResponse.BodyHandlers.ofString()).body());
    }
}
