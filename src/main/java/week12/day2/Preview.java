package week12.day2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * [예습 파일] Week 12 Day 2 — HTTP 통신 (Java 11 HttpClient)
 * 
 * [핵심 개념: 웹 자원 조회를 위한 HTTP 프로토콜]
 * 1. HTTP(HyperText Transfer Protocol):
 *    - 소켓처럼 계속 연결을 유지하지 않고, 요청(Request)을 보내면 응답(Response)을 받고 즉각 연결을 완전히 끊어버리는 비연결성(Stateless) 기반의 전 세계 표준 웹 프로토콜입니다.
 * 
 * 2. HttpClient (Java 11+ 모던 표준 API):
 *    - 자바의 옛 구식 `HttpURLConnection`의 지저분한 설정 방식에서 벗어나, 세련된 빌더 패턴과 논블로킹 비동기 통신까지 깔끔하게 지원하도록 대개편된 자바 공식 HTTP 통신 모듈입니다.
 */
public class Preview {
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("상태 코드: " + response.statusCode());
            System.out.println("본문: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
