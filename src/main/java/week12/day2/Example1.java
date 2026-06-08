package week12.day2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * [학습 예제 1] Week 12 Day 2 — HTTP 통신 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1] Java 11+ HttpClient (최신 방법)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - HttpClient: Java 11부터 제공하는 현대적 HTTP 클라이언트
 *  - HttpRequest.newBuilder().uri(URI).GET().build(): 요청 빌더 패턴
 *  - client.send(request, BodyHandlers.ofString()): 동기 방식 전송
 *
 * [문제별 학습 목표]
 * - 문제 1: HttpClient GET — https://jsonplaceholder.typicode.com/users/1 요청
 */
public class Example1 {
    static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) throws Exception {
        System.out.println("=== Lab 1: HttpClient GET 요청 ===");
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/users/1"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println("응답 코드: " + response.statusCode());
        System.out.println("응답 본문 (첫 100자): "
                + response.body().substring(0, Math.min(100, response.body().length())) + "...");
    }
}
