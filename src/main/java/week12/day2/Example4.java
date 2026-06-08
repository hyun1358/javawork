package week12.day2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * [학습 예제 4] Week 12 Day 2 — HTTP 통신 완전 정복
 *
 * [문제별 학습 목표]
 * - 문제 4: 404 확인 — /users/9999 로 요청 → 404 응답 코드 확인
 */
public class Example4 {
    static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) throws Exception {
        System.out.println("\n=== Lab 4: 404 응답 확인 ===");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req404 = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/users/9999")) // 존재하지 않는 리소스
                .GET()
                .build();
        HttpResponse<String> res404 = client.send(req404, HttpResponse.BodyHandlers.ofString());

        System.out.println("응답 코드: " + res404.statusCode()); // 404 예상
        if (res404.statusCode() == 404) {
            System.out.println("404 Not Found — 리소스가 존재하지 않습니다.");
        }
    }
}
